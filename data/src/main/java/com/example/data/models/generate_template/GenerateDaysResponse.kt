package com.example.data.models.generate_template

import com.squareup.moshi.Json

data class GenerateDaysResponse(
    @Json(name = "monday") val monday: GenerateTemplateResponse? = null,
    @Json(name = "tuesday") val tuesday: GenerateTemplateResponse? = null,
    @Json(name = "wednesday") val wednesday: GenerateTemplateResponse? = null,
    @Json(name = "thursday") val thursday: GenerateTemplateResponse? = null,
    @Json(name = "friday") val friday: GenerateTemplateResponse? = null,
    @Json(name = "saturday") val saturday: GenerateTemplateResponse? = null,
    @Json(name = "sunday") val sunday: GenerateTemplateResponse? = null
)