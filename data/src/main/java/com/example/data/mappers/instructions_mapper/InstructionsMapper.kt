package com.example.data.mappers.instructions_mapper

import com.example.data.db.instructions.EquipmentIngredientsEntity
import com.example.data.db.instructions.InstructionsEntity
import com.example.data.models.instructions.EquipmentIngredientResponse
import com.example.data.models.instructions.InstructionStepsResponse
import javax.inject.Inject

class InstructionsMapper @Inject constructor() {
    operator fun invoke(instructionStepsResponse: InstructionStepsResponse) =
        with(instructionStepsResponse) {
            InstructionsEntity(
                equipment = if (instructionStepsResponse.equipment != null) instructionStepsResponse.equipment.size
                else 0,
                ingredients = if (instructionStepsResponse.ingredients != null) instructionStepsResponse.ingredients.size
                else 0,
                number = instructionStepsResponse.number ?: 0,
                step = instructionStepsResponse.step ?: ""
            )
        }

    fun equipmentIngredientMapper(elements: List<EquipmentIngredientResponse>): List<EquipmentIngredientsEntity> {
        return elements.map {
            EquipmentIngredientsEntity(
                id = it.id ?: 0,
                name = it.name ?: "",
                image = it.image ?: ""
            )
        }
    }
}