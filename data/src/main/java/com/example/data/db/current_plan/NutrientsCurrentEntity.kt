package com.example.data.db.current_plan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nutrients_table")
data class NutrientsCurrentEntity(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    @ColumnInfo("calories") val calories: Double,
    @ColumnInfo("carbohydrates") val carbohydrates: Double,
    @ColumnInfo("fat") val fat: Double,
    @ColumnInfo("protein") val protein: Double
)