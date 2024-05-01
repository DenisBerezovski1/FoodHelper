package com.example.data.db.food

import androidx.room.*

@Dao
interface FoodDao {
    @Query("SELECT * FROM breakfast_table")
    fun getAllBreakfast(): List<BreakfastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBreakfast(news: List<BreakfastEntity>)

    @Delete
    fun deleteAllBreakfast(news: List<BreakfastEntity>)

    @Query("SELECT * FROM brunch_table")
    fun getAllBrunch(): List<BrunchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBrunch(news: List<BrunchEntity>)

    @Delete
    fun deleteAllBrunch(news: List<BrunchEntity>)

    @Query("SELECT * FROM lunch_table")
    fun getAllLunch(): List<LunchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLunch(news: List<LunchEntity>)

    @Delete
    fun deleteAllLunch(news: List<LunchEntity>)

    @Query("SELECT * FROM dinner_table")
    fun getAllDinner(): List<DinnerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDinner(news: List<DinnerEntity>)

    @Delete
    fun deleteAllDinner(news: List<DinnerEntity>)

}