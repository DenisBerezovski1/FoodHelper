package com.example.data.db.instructions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipmentIngredient_table")
data class EquipmentIngredientsEntity(
    @PrimaryKey(autoGenerate = true) val equipmentIngredientId: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "image") val image: String,
)