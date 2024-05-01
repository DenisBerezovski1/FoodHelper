package com.example.data.db.meal_plans

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MondayEntity::class, TuesdayEntity::class, WednesdayEntity::class, ThursdayEntity::class, FridayEntity::class, SaturdayEntity::class, SundayEntity::class, NutrientsPlanEntity::class],
    version = 1
)
abstract class MealPlansDataBase : RoomDatabase() {
    abstract fun mealPlansDao(): MealPlansDao
}