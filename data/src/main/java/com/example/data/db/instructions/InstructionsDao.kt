package com.example.data.db.instructions

import androidx.room.*

@Dao
interface InstructionsDao {
    @Query("SELECT * FROM instructions_table")
    fun getAllInstructions(): List<InstructionsEntity>

    @Query("SELECT * FROM equipmentIngredient_table")
    fun getAllEquipmentIngredients(): List<EquipmentIngredientsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllInstructions(instructions: InstructionsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEquipmentIngredients(instructions: List<EquipmentIngredientsEntity>)

    @Delete
    fun deleteInstructions(instructions: List<InstructionsEntity>)

    @Delete
    fun deleteEquipmentIngredients(instructions: List<EquipmentIngredientsEntity>)
}