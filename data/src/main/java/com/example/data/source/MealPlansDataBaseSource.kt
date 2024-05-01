package com.example.data.source

import com.example.data.db.meal_plans.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealPlansDataBaseSource @Inject constructor(
    private val mealPlansDao: MealPlansDao
) {
    suspend fun getAllMonday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllMonday()
    }

    suspend fun getMondayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getMondayPlans()
    }

    suspend fun getMondayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getMondayByPlan(planName)
    }

    suspend fun insertAllMonday(news: List<MondayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllMonday(news)
    }

    suspend fun deleteAllMonday(news: List<MondayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllMonday(news)
    }

    suspend fun deleteMonday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteMonday(plan)
    }

    suspend fun getAllTuesday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllTuesday()
    }

    suspend fun getTuesdayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getTuesdayPlans()
    }

    suspend fun getTuesdayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getTuesdayByPlan(planName)
    }

    suspend fun insertAllTuesday(news: List<TuesdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllTuesday(news)
    }

    suspend fun deleteAllTuesday(news: List<TuesdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllTuesday(news)
    }

    suspend fun deleteTuesday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteTuesday(plan)
    }

    suspend fun getAllWednesday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllWednesday()
    }

    suspend fun getWednesdayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getWednesdayPlans()
    }

    suspend fun getWednesdayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getWednesdayByPlan(planName)
    }

    suspend fun insertAllWednesday(news: List<WednesdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllWednesday(news)
    }

    suspend fun deleteAllWednesday(news: List<WednesdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllWednesday(news)
    }

    suspend fun deleteWednesday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteWednesday(plan)
    }

    suspend fun getAllThursday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllThursday()
    }

    suspend fun getThursdayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getThursdayPlans()
    }

    suspend fun getThursdayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getThursdayByPlan(planName)
    }

    suspend fun insertAllThursday(news: List<ThursdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllThursday(news)
    }

    suspend fun deleteAllThursday(news: List<ThursdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllThursday(news)
    }

    suspend fun deleteThursday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteThursday(plan)
    }

    suspend fun getAllFriday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllFriday()
    }

    suspend fun getFridayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getFridayPlans()
    }

    suspend fun getFridayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getFridayByPlan(planName)
    }

    suspend fun insertAllFriday(news: List<FridayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllFriday(news)
    }

    suspend fun deleteAllFriday(news: List<FridayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllFriday(news)
    }

    suspend fun deleteFriday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteFriday(plan)
    }

    suspend fun getAllSaturday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllSaturday()
    }

    suspend fun getSaturdayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getSaturdayPlans()
    }

    suspend fun getSaturdayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getSaturdayByPlan(planName)
    }

    suspend fun insertAllSaturday(news: List<SaturdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllSaturday(news)
    }

    suspend fun deleteAllSaturday(news: List<SaturdayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllSaturday(news)
    }

    suspend fun deleteSaturday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteSaturday(plan)
    }

    suspend fun getAllSunday() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllSunday()
    }

    suspend fun getSundayPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getSundayPlans()
    }

    suspend fun getSundayByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getSundayByPlan(planName)
    }

    suspend fun insertAllSunday(news: List<SundayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllSunday(news)
    }

    suspend fun deleteAllSunday(news: List<SundayEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllSunday(news)
    }

    suspend fun deleteSunday(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteSunday(plan)
    }

    suspend fun getAllNutrients() = withContext(Dispatchers.IO) {
        mealPlansDao.getAllNutrients()
    }

    suspend fun getNutrientsPlans() = withContext(Dispatchers.IO) {
        mealPlansDao.getNutrientsPlans()
    }

    suspend fun getNutrientsByPlan(planName: String) = withContext(Dispatchers.IO) {
        mealPlansDao.getNutrientsByPlan(planName)
    }

    suspend fun insertAllNutrients(news: List<NutrientsPlanEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.insertAllNutrients(news)
    }

    suspend fun deleteAllNutrients(news: List<NutrientsPlanEntity>) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteAllNutrients(news)
    }

    suspend fun deleteNutrients(plan: String) = withContext(Dispatchers.IO) {
        mealPlansDao.deleteNutrients(plan)
    }
}