package com.example.data.models.generate_template

import com.squareup.moshi.Json

data class GenerateWeekResponse (
    @Json(name = "week") val week: GenerateDaysResponse? = null,
)