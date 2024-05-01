package com.example.domain.models.generate_template

data class GenerateTemplateData(
    val meals: List<GenerateMealsData>,
    val nutrients: NutrientsTemplateData
)