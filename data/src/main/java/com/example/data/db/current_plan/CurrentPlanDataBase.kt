package com.example.data.db.current_plan

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MondayCurrentEntity::class, TuesdayCurrentEntity::class, WednesdayCurrentEntity::class, ThursdayCurrentEntity::class, FridayCurrentEntity::class, SaturdayCurrentEntity::class, SundayCurrentEntity::class, NutrientsCurrentEntity::class],
    version = 1
)
abstract class CurrentPlanDataBase : RoomDatabase() {
    abstract fun currentPlanDao(): CurrentPlanDao
}