package com.example.data.models.instructions

import com.squareup.moshi.Json

data class EquipmentIngredientResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "image") val image: String? = null
)