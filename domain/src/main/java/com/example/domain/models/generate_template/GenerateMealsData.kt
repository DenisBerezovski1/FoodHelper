package com.example.domain.models.generate_template


data class GenerateMealsData(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val imageType: String
)