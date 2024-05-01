package com.example.data.db.instructions

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [InstructionsEntity::class, EquipmentIngredientsEntity::class], version = 1)
abstract class InstructionsDataBase : RoomDatabase() {
    abstract fun instructionsDao(): InstructionsDao
}