package com.example.data.db.food

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BreakfastEntity::class, BrunchEntity::class, LunchEntity::class, DinnerEntity::class],
    version = 1
)
abstract class FoodDataBase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}