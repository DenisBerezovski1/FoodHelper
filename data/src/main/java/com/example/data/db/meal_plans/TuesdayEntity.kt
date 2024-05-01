package com.example.data.db.meal_plans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tuesday_table")
data class TuesdayEntity(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("plan") val plan: String,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("readyInMinutes") val readyInMinutes: Int,
    @ColumnInfo("servings") val servings: Int,
    @ColumnInfo("sourceUrl") val sourceUrl: String,
    @ColumnInfo("imageType") val imageType: String
)