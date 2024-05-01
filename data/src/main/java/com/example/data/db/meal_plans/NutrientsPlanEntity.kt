package com.example.data.db.meal_plans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nutrients_table")
data class NutrientsPlanEntity(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    @ColumnInfo("plan") val plan: String,
    @ColumnInfo("calories") val calories: Double,
    @ColumnInfo("carbohydrates") val carbohydrates: Double,
    @ColumnInfo("fat") val fat: Double,
    @ColumnInfo("protein") val protein: Double
)