package com.example.data.db.instructions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instructions_table")
data class InstructionsEntity(
    @PrimaryKey(autoGenerate = true) val instructionsId: Int = 0,
    @ColumnInfo(name = "equipment") val equipment: Int,
    @ColumnInfo(name = "ingredients") var ingredients: Int,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "step") val step: String
)