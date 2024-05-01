package com.example.data

import com.example.data.db.instructions.EquipmentIngredientsEntity
import com.example.data.mappers.food_mapper.FoodEntityMapper
import com.example.data.mappers.food_mapper.FoodResultsMapper
import com.example.data.mappers.generate_template_mapper.CurrentToMealPlansMapper
import com.example.data.mappers.generate_template_mapper.GenerateTemplateMapper
import com.example.data.mappers.generate_template_mapper.TemplateEntityMapper
import com.example.data.mappers.instructions_mapper.InstructionsEntityMapper
import com.example.data.mappers.instructions_mapper.InstructionsMapper
import com.example.data.mappers.user_mapper.ChangeNameMapper
import com.example.data.mappers.user_mapper.DayPlanMapper
import com.example.data.network.*
import com.example.data.source.*
import com.example.domain.Repository
import com.example.domain.models.food.FoodData
import com.example.domain.models.generate_template.GenerateTemplateData
import com.example.domain.models.generate_template.NutrientsTemplateData
import com.example.domain.models.instructions.InstructionsData
import com.example.domain.models.user.DayPlanData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val analyzedInstructionService: AnalyzedInstructionService,
    private val generateTemplateService: GenerateTemplateService,
    private val foodMapper: FoodResultsMapper,
    private val foodEntityMapper: FoodEntityMapper,
    private val instructionsMapper: InstructionsMapper,
    private val instructionsEntityMapper: InstructionsEntityMapper,
    private val generateTemplateMapper: GenerateTemplateMapper,
    private val templateEntityMapper: TemplateEntityMapper,
    private val currentToMealPlansMapper: CurrentToMealPlansMapper,
    private val dayPlanMapper: DayPlanMapper,
    private val changeNameMapper: ChangeNameMapper,
    private val userSource: UserDataSource,
    private val foodDataBaseSource: FoodDataBaseSource,
    private val instructionsDataBaseSource: InstructionsDataBaseSource,
    private val currentPlanDBSource: CurrentPlanDataBaseSource,
    private val mealPlansDBSource: MealPlansDataBaseSource,
) : Repository {
    override suspend fun getFoodList(
        query: String,
        cuisine: String,
        diet: String,
        intolerance: String,
        isConnected: Boolean
    ): List<FoodData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response = (foodService.getFood(
                    query,
                    cuisine,
                    diet,
                    intolerance,
                    userSource.getUserToken()
                )).results
                val foodList = (response ?: listOf()).map { foodMapper(it) }
                foodList.map { foodEntityMapper(it) }
            } else emptyList()
        }
    }

    override suspend fun getBreakfastList(query: String, isConnected: Boolean): List<FoodData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response = (foodService.getFood(query, userSource.getUserToken())).results
                val foodList = (response ?: listOf()).map { foodMapper(it) }
                foodDataBaseSource.deleteAllBreakfast(foodDataBaseSource.getAllBreakfast())
                foodDataBaseSource.insertAllBreakfast(foodList)
                foodList.map { foodEntityMapper(it) }
            } else {
                foodDataBaseSource.getAllBreakfast().map { foodEntityMapper(it) }
            }
        }
    }

    override suspend fun getBrunchList(query: String, isConnected: Boolean): List<FoodData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response =
                    (foodService.getFood(query, userSource.getUserToken())).results
                val foodList = (response ?: listOf()).map { foodMapper.toBrunchEntity(it) }
                foodDataBaseSource.deleteAllBrunch(foodDataBaseSource.getAllBrunch())
                foodDataBaseSource.insertAllBrunch(foodList)
                foodList.map { foodEntityMapper(it) }
            } else {
                foodDataBaseSource.getAllBrunch().map { foodEntityMapper(it) }
            }
        }
    }

    override suspend fun getLunchList(query: String, isConnected: Boolean): List<FoodData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response =
                    (foodService.getFood(query, userSource.getUserToken())).results
                val foodList = (response ?: listOf()).map { foodMapper.toLunchEntity(it) }
                foodDataBaseSource.deleteAllLunch(foodDataBaseSource.getAllLunch())
                foodDataBaseSource.insertAllLunch(foodList)
                foodList.map { foodEntityMapper(it) }
            } else {
                foodDataBaseSource.getAllLunch().map { foodEntityMapper(it) }
            }
        }
    }

    override suspend fun getDinnerList(query: String, isConnected: Boolean): List<FoodData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response =
                    (foodService.getFood(query, userSource.getUserToken())).results
                val foodList = (response ?: listOf()).map { foodMapper.toDinnerEntity(it) }
                foodDataBaseSource.deleteAllDinner(foodDataBaseSource.getAllDinner())
                foodDataBaseSource.insertAllDinner(foodList)
                foodList.map { foodEntityMapper(it) }
            } else {
                foodDataBaseSource.getAllDinner().map { foodEntityMapper(it) }
            }
        }
    }

    override suspend fun getInstructionsList(id: String, isConnected: Boolean)
            : List<InstructionsData> {
        return withContext(Dispatchers.IO) {
            if (isConnected) {
                val response =
                    (analyzedInstructionService.getInstruction(id, userSource.getUserToken()))
                instructionsDataBaseSource.deleteInstructions(instructionsDataBaseSource.getAllInstructions())
                instructionsDataBaseSource.deleteEquipmentIngredients(instructionsDataBaseSource.getAllEquipmentIngredients())
                var equipmentEntity: List<EquipmentIngredientsEntity> = listOf()
                var ingredientsEntity: List<EquipmentIngredientsEntity> = listOf()
                val instructionsList =
                    response[0].steps?.map {
                        val instructionsEntity = instructionsMapper(it)
                        if (it.equipment != null) {
                            equipmentEntity =
                                instructionsMapper.equipmentIngredientMapper(it.equipment)
                            instructionsDataBaseSource.insertAllEquipmentIngredients(equipmentEntity)
                        }
                        if (it.ingredients != null) {
                            ingredientsEntity =
                                instructionsMapper.equipmentIngredientMapper(it.ingredients)
                            instructionsDataBaseSource.insertAllEquipmentIngredients(
                                ingredientsEntity
                            )
                        }
                        instructionsDataBaseSource.insertAllInstructions(instructionsEntity)
                        instructionsEntityMapper(
                            instructionsEntity,
                            equipmentEntity,
                            ingredientsEntity
                        )
                    } ?: listOf()
                instructionsList
            } else {
                val equipmentIngredientsList =
                    instructionsDataBaseSource.getAllEquipmentIngredients()
                var equipmentEntity: List<EquipmentIngredientsEntity>
                var ingredientsEntity: List<EquipmentIngredientsEntity>
                var j = 0
                instructionsDataBaseSource.getAllInstructions()
                    .map {
                        equipmentEntity = equipmentIngredientsList.subList(j, j + it.equipment)
                        j += it.equipment
                        ingredientsEntity = equipmentIngredientsList.subList(j, j + it.ingredients)
                        j += it.ingredients
                        instructionsEntityMapper(it, equipmentEntity, ingredientsEntity)
                    }
            }
        }
    }

    override suspend fun weekTemplateToDB(
        timeFrame: String,
        targetCalories: String,
        diet: String,
        exclude: String,
    ) {
        withContext(Dispatchers.IO) {
            val response = generateTemplateService.generateWeekTemplate(
                timeFrame,
                targetCalories,
                diet,
                exclude,
                userSource.getUserToken()
            ).week
            currentPlanDBSource.deleteAllMonday(currentPlanDBSource.getAllMonday())
            currentPlanDBSource.deleteAllTuesday(currentPlanDBSource.getAllTuesday())
            currentPlanDBSource.deleteAllWednesday(currentPlanDBSource.getAllWednesday())
            currentPlanDBSource.deleteAllThursday(currentPlanDBSource.getAllThursday())
            currentPlanDBSource.deleteAllFriday(currentPlanDBSource.getAllFriday())
            currentPlanDBSource.deleteAllSaturday(currentPlanDBSource.getAllSaturday())
            currentPlanDBSource.deleteAllSunday(currentPlanDBSource.getAllSunday())
            currentPlanDBSource.deleteAllNutrients(currentPlanDBSource.getAllNutrients())

            response?.monday?.let { monday ->
                monday.meals?.let { generateTemplateMapper.toMondayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllMonday(it) }
                monday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.tuesday?.let { tuesday ->
                tuesday.meals?.let { generateTemplateMapper.toTuesdayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllTuesday(it) }
                tuesday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.wednesday?.let { wednesday ->
                wednesday.meals?.let { generateTemplateMapper.toWednesdayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllWednesday(it) }
                wednesday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.thursday?.let { thursday ->
                thursday.meals?.let { generateTemplateMapper.toThursdayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllThursday(it) }
                thursday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.friday?.let { friday ->
                friday.meals?.let { generateTemplateMapper.toFridayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllFriday(it) }
                friday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.saturday?.let { saturday ->
                saturday.meals?.let { generateTemplateMapper.toSaturdayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllSaturday(it) }
                saturday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
            response?.sunday?.let { sunday ->
                sunday.meals?.let { generateTemplateMapper.toSundayEntity(it) }
                    ?.let { currentPlanDBSource.insertAllSunday(it) }
                sunday.nutrients?.let { generateTemplateMapper.toNutrientsEntity(it) }
                    ?.let { currentPlanDBSource.insertAllNutrients(it) }
            }
        }
    }

    override suspend fun generateDayTemplate(
        day: String
    ): GenerateTemplateData {
        val nutrientsList = currentPlanDBSource.getAllNutrients()
        return when (day) {
            "monday" -> GenerateTemplateData(
                templateEntityMapper.mondayMealsMapper(currentPlanDBSource.getAllMonday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[0])
            )
            "tuesday" -> GenerateTemplateData(
                templateEntityMapper.tuesdayMealsMapper(currentPlanDBSource.getAllTuesday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[1])
            )
            "wednesday" -> GenerateTemplateData(
                templateEntityMapper.wednesdayMealsMapper(currentPlanDBSource.getAllWednesday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[2])
            )
            "thursday" -> GenerateTemplateData(
                templateEntityMapper.thursdayMealsMapper(currentPlanDBSource.getAllThursday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[3])
            )
            "friday" -> GenerateTemplateData(
                templateEntityMapper.fridayMealsMapper(currentPlanDBSource.getAllFriday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[4])
            )
            "saturday" -> GenerateTemplateData(
                templateEntityMapper.saturdayMealsMapper(currentPlanDBSource.getAllSaturday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[5])
            )
            "sunday" -> GenerateTemplateData(
                templateEntityMapper.sundayMealsMapper(currentPlanDBSource.getAllSunday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[6])
            )
            else -> GenerateTemplateData(
                templateEntityMapper.mondayMealsMapper(currentPlanDBSource.getAllMonday()),
                templateEntityMapper.nutrientsMapper(nutrientsList[0])
            )
        }
    }

    override suspend fun addPlanToDB(plan: String) {
        withContext(Dispatchers.IO) {
            mealPlansDBSource.deleteMonday(plan)
            mealPlansDBSource.deleteTuesday(plan)
            mealPlansDBSource.deleteWednesday(plan)
            mealPlansDBSource.deleteThursday(plan)
            mealPlansDBSource.deleteFriday(plan)
            mealPlansDBSource.deleteSaturday(plan)
            mealPlansDBSource.deleteSunday(plan)
            mealPlansDBSource.deleteNutrients(plan)

            mealPlansDBSource.insertAllMonday(
                currentToMealPlansMapper.toMondayEntity(
                    currentPlanDBSource.getAllMonday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllTuesday(
                currentToMealPlansMapper.toTuesdayEntity(
                    currentPlanDBSource.getAllTuesday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllWednesday(
                currentToMealPlansMapper.toWednesdayEntity(
                    currentPlanDBSource.getAllWednesday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllThursday(
                currentToMealPlansMapper.toThursdayEntity(
                    currentPlanDBSource.getAllThursday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllFriday(
                currentToMealPlansMapper.toFridayEntity(
                    currentPlanDBSource.getAllFriday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllSaturday(
                currentToMealPlansMapper.toSaturdayEntity(
                    currentPlanDBSource.getAllSaturday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllSunday(
                currentToMealPlansMapper.toSundayEntity(
                    currentPlanDBSource.getAllSunday(),
                    plan
                )
            )
            mealPlansDBSource.insertAllNutrients(
                currentPlanDBSource.getAllNutrients()
                    .map { currentToMealPlansMapper.toNutrientsEntity(it, plan) })
        }
    }

    override suspend fun getPlans(): List<String> {
        return withContext(Dispatchers.IO) {
            val plans = mutableListOf<String>()
            mealPlansDBSource.getMondayPlans().map {
                plans.add(it.plan)
            }
            plans
        }
    }

    override suspend fun getCurrentPlan(currentPlan: String, day: Int): List<DayPlanData> {
        return withContext(Dispatchers.IO) {
            val dayMeals = when (day) {
                2 -> dayPlanMapper.fromMonday(mealPlansDBSource.getMondayByPlan(currentPlan))
                3 -> dayPlanMapper.fromTuesday(mealPlansDBSource.getTuesdayByPlan(currentPlan))
                4 -> dayPlanMapper.fromWednesday(
                    mealPlansDBSource.getWednesdayByPlan(
                        currentPlan
                    )
                )
                5 -> dayPlanMapper.fromThursday(
                    mealPlansDBSource.getThursdayByPlan(
                        currentPlan
                    )
                )
                6 -> dayPlanMapper.fromFriday(mealPlansDBSource.getFridayByPlan(currentPlan))
                7 -> dayPlanMapper.fromSaturday(
                    mealPlansDBSource.getSaturdayByPlan(
                        currentPlan
                    )
                )
                1 -> dayPlanMapper.fromSunday(mealPlansDBSource.getSundayByPlan(currentPlan))
                else -> dayPlanMapper.fromMonday(mealPlansDBSource.getMondayByPlan(currentPlan))
            }
            dayMeals
        }
    }

    override suspend fun getCurrentNutrients(
        currentPlan: String,
        day: Int
    ): NutrientsTemplateData {
        return withContext(Dispatchers.IO) {
            val nutrients = when (day) {
                2 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[0])
                3 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[1])
                4 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[2])
                5 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[3])
                6 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[4])
                7 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[5])
                1 -> dayPlanMapper.nutrientsMapper(mealPlansDBSource.getNutrientsByPlan(currentPlan)[6])
                else -> dayPlanMapper.nutrientsMapper(
                    mealPlansDBSource.getNutrientsByPlan(
                        currentPlan
                    )[0]
                )
            }
            nutrients
        }
    }

    override suspend fun changePlanName(oldName: String, newName: String): List<String> {
        return withContext(Dispatchers.IO) {
            val mondayList = changeNameMapper.changeMondayPlan(
                mealPlansDBSource.getMondayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteMonday(oldName)
            mealPlansDBSource.insertAllMonday(mondayList)
            val tuesdayList = changeNameMapper.changeTuesdayPlan(
                mealPlansDBSource.getTuesdayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteTuesday(oldName)
            mealPlansDBSource.insertAllTuesday(tuesdayList)
            val wednesdayList = changeNameMapper.changeWednesdayPlan(
                mealPlansDBSource.getWednesdayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteWednesday(oldName)
            mealPlansDBSource.insertAllWednesday(wednesdayList)
            val thursdayList = changeNameMapper.changeThursdayPlan(
                mealPlansDBSource.getThursdayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteThursday(oldName)
            mealPlansDBSource.insertAllThursday(thursdayList)
            val fridayList = changeNameMapper.changeFridayPlan(
                mealPlansDBSource.getFridayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteFriday(oldName)
            mealPlansDBSource.insertAllFriday(fridayList)
            val saturdayList = changeNameMapper.changeSaturdayPlan(
                mealPlansDBSource.getSaturdayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteSaturday(oldName)
            mealPlansDBSource.insertAllSaturday(saturdayList)
            val sundayList = changeNameMapper.changeSundayPlan(
                mealPlansDBSource.getSundayByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteSunday(oldName)
            mealPlansDBSource.insertAllSunday(sundayList)
            val nutrientsList = changeNameMapper.changeNutrientsPlan(
                mealPlansDBSource.getNutrientsByPlan(oldName),
                newName
            )
            mealPlansDBSource.deleteNutrients(oldName)
            mealPlansDBSource.insertAllNutrients(nutrientsList)
            getPlans()
        }
    }

    override suspend fun deletePlan(name: String): List<String> {
        return withContext(Dispatchers.IO) {
            mealPlansDBSource.deleteMonday(name)
            mealPlansDBSource.deleteTuesday(name)
            mealPlansDBSource.deleteWednesday(name)
            mealPlansDBSource.deleteThursday(name)
            mealPlansDBSource.deleteFriday(name)
            mealPlansDBSource.deleteSaturday(name)
            mealPlansDBSource.deleteSunday(name)
            mealPlansDBSource.deleteNutrients(name)
            getPlans()
        }
    }

    override fun setToken(token: String) {
        userSource.setUserToken(token)
    }

    override fun setBreakfastUpdate(update: Boolean) {
        userSource.setBreakfastUpdate(update)
    }

    override fun getBreakfastUpdate(): Boolean {
        return userSource.getBreakfastUpdate()
    }

    override fun setBrunchUpdate(update: Boolean) {
        userSource.setBrunchUpdate(update)
    }

    override fun getBrunchUpdate(): Boolean {
        return userSource.getBrunchUpdate()
    }

    override fun setLunchUpdate(update: Boolean) {
        userSource.setLunchUpdate(update)
    }

    override fun getLunchUpdate(): Boolean {
        return userSource.getLunchUpdate()
    }

    override fun setDinnerUpdate(update: Boolean) {
        userSource.setDinnerUpdate(update)
    }

    override fun getDinnerUpdate(): Boolean {
        return userSource.getDinnerUpdate()
    }
}