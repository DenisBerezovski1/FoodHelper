package com.example.data.models.generate_template

import com.squareup.moshi.Json

data class GenerateTemplateResponse(
    @Json(name = "meals") val meals: List<GenerateMealsResponse>? = null,
    @Json(name = "nutrients") val nutrients: NutrientsTemplateResponse? = null
)