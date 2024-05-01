package com.example.data.models.instructions

import com.squareup.moshi.Json

data class InstructionStepsResponse (
    @Json(name = "equipment") val equipment: List<EquipmentIngredientResponse>? = null,
    @Json(name = "ingredients") val ingredients: List<EquipmentIngredientResponse>? = null,
    @Json(name = "number") val number: Int? = null,
    @Json(name = "step") val step: String? = null
)