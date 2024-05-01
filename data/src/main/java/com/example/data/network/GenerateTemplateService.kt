package com.example.data.network

import com.example.data.models.generate_template.GenerateWeekResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenerateTemplateService {
    @GET("mealplanner/generate")
    suspend fun generateWeekTemplate(
        @Query("timeFrame") timeFrame: String,
        @Query("targetCalories") targetCalories: String,
        @Query("diet") diet: String,
        @Query("exclude") exclude: String,
        @Query("apiKey") token: String
    ): GenerateWeekResponse
}