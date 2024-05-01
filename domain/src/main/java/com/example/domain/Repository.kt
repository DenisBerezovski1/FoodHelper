package com.example.domain

import com.example.domain.models.food.FoodData
import com.example.domain.models.generate_template.GenerateTemplateData
import com.example.domain.models.generate_template.NutrientsTemplateData
import com.example.domain.models.instructions.InstructionsData
import com.example.domain.models.user.DayPlanData

interface Repository {
    suspend fun getFoodList(query: String, cuisine: String, diet: String, intolerance: String, isConnected: Boolean): List<FoodData>

    suspend fun getBreakfastList(query: String, isConnected: Boolean): List<FoodData>

    suspend fun getBrunchList(query: String, isConnected: Boolean): List<FoodData>

    suspend fun getLunchList(query: String, isConnected: Boolean): List<FoodData>

    suspend fun getDinnerList(query: String, isConnected: Boolean): List<FoodData>

    suspend fun getInstructionsList(id: String, isConnected: Boolean): List<InstructionsData>

    suspend fun weekTemplateToDB(timeFrame: String, targetCalories: String, diet: String, exclude: String)

    suspend fun generateDayTemplate(day: String): GenerateTemplateData

    suspend fun addPlanToDB(plan: String)

    suspend fun getPlans() : List<String>

    suspend fun getCurrentPlan(currentPlan: String, day: Int) : List<DayPlanData>

    suspend fun getCurrentNutrients(currentPlan: String, day: Int) : NutrientsTemplateData

    suspend fun changePlanName(oldName: String, newName: String) : List<String>

    suspend fun deletePlan(name: String) : List<String>

    fun setToken(token: String)

    fun setBreakfastUpdate(update: Boolean)

    fun getBreakfastUpdate(): Boolean

    fun setBrunchUpdate(update: Boolean)

    fun getBrunchUpdate(): Boolean

    fun setLunchUpdate(update: Boolean)

    fun getLunchUpdate(): Boolean

    fun setDinnerUpdate(update: Boolean)

    fun getDinnerUpdate(): Boolean

}