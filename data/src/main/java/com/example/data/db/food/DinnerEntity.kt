package com.example.data.db.food

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dinner_table")
data class DinnerEntity(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "imageType") val imageType: String
)