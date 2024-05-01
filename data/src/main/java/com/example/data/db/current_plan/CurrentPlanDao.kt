package com.example.data.db.current_plan

import androidx.room.*

@Dao
interface CurrentPlanDao {
    @Query("SELECT * FROM monday_table")
    fun getAllMonday(): List<MondayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMonday(news: List<MondayCurrentEntity>)

    @Delete
    fun deleteAllMonday(news: List<MondayCurrentEntity>)

    @Query("SELECT * FROM tuesday_table")
    fun getAllTuesday(): List<TuesdayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTuesday(news: List<TuesdayCurrentEntity>)

    @Delete
    fun deleteAllTuesday(news: List<TuesdayCurrentEntity>)

    @Query("SELECT * FROM wednesday_table")
    fun getAllWednesday(): List<WednesdayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllWednesday(news: List<WednesdayCurrentEntity>)

    @Delete
    fun deleteAllWednesday(news: List<WednesdayCurrentEntity>)

    @Query("SELECT * FROM thursday_table")
    fun getAllThursday(): List<ThursdayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllThursday(news: List<ThursdayCurrentEntity>)

    @Delete
    fun deleteAllThursday(news: List<ThursdayCurrentEntity>)

    @Query("SELECT * FROM friday_table")
    fun getAllFriday(): List<FridayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFriday(news: List<FridayCurrentEntity>)

    @Delete
    fun deleteAllFriday(news: List<FridayCurrentEntity>)

    @Query("SELECT * FROM saturday_table")
    fun getAllSaturday(): List<SaturdayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSaturday(news: List<SaturdayCurrentEntity>)

    @Delete
    fun deleteAllSaturday(news: List<SaturdayCurrentEntity>)

    @Query("SELECT * FROM sunday_table")
    fun getAllSunday(): List<SundayCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSunday(news: List<SundayCurrentEntity>)

    @Delete
    fun deleteAllSunday(news: List<SundayCurrentEntity>)

    @Query("SELECT * FROM nutrients_table")
    fun getAllNutrients(): List<NutrientsCurrentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNutrients(news: NutrientsCurrentEntity)

    @Delete
    fun deleteAllNutrients(news: List<NutrientsCurrentEntity>)

}