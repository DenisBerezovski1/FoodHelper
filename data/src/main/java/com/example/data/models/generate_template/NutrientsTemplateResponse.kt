package com.example.data.models.generate_template

import com.squareup.moshi.Json

data class NutrientsTemplateResponse(
    @Json(name = "calories") val calories: Double? = null,
    @Json(name = "carbohydrates") val carbohydrates: Double? = null,
    @Json(name = "fat") val fat: Double? = null,
    @Json(name = "protein") val protein: Double? = null,
)