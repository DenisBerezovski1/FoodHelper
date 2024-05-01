package com.example.domain.models.user

data class DayPlanData(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val imageType: String
)