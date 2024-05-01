package com.example.data.db.current_plan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sunday_table")
data class SundayCurrentEntity(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("readyInMinutes") val readyInMinutes: Int,
    @ColumnInfo("servings") val servings: Int,
    @ColumnInfo("sourceUrl") val sourceUrl: String,
    @ColumnInfo("imageType") val imageType: String
)