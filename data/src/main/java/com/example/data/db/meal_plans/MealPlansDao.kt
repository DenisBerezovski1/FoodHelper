package com.example.data.db.meal_plans

import androidx.room.*

@Dao
interface MealPlansDao {
    @Query("SELECT * FROM monday_table")
    fun getAllMonday(): List<MondayEntity>

    @Query("SELECT DISTINCT plan, * FROM monday_table GROUP BY plan")
    fun getMondayPlans(): List<MondayEntity>

    @Query("SELECT * FROM monday_table WHERE plan = :planName")
    fun getMondayByPlan(planName: String): List<MondayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMonday(news: List<MondayEntity>)

    @Delete
    fun deleteAllMonday(news: List<MondayEntity>)

    @Query("DELETE FROM monday_table WHERE plan = :planName")
    fun deleteMonday(planName: String)

    @Query("SELECT * FROM tuesday_table")
    fun getAllTuesday(): List<TuesdayEntity>

    @Query("SELECT DISTINCT plan, * FROM tuesday_table GROUP BY plan")
    fun getTuesdayPlans(): List<TuesdayEntity>

    @Query("SELECT * FROM tuesday_table WHERE plan = :planName")
    fun getTuesdayByPlan(planName: String): List<TuesdayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTuesday(news: List<TuesdayEntity>)

    @Delete
    fun deleteAllTuesday(news: List<TuesdayEntity>)

    @Query("DELETE FROM tuesday_table WHERE plan = :planName")
    fun deleteTuesday(planName: String)

    @Query("SELECT * FROM wednesday_table")
    fun getAllWednesday(): List<WednesdayEntity>

    @Query("SELECT DISTINCT plan, * FROM wednesday_table GROUP BY plan")
    fun getWednesdayPlans(): List<WednesdayEntity>

    @Query("SELECT * FROM wednesday_table WHERE plan = :planName")
    fun getWednesdayByPlan(planName: String): List<WednesdayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllWednesday(news: List<WednesdayEntity>)

    @Delete
    fun deleteAllWednesday(news: List<WednesdayEntity>)

    @Query("DELETE FROM wednesday_table WHERE plan = :planName")
    fun deleteWednesday(planName: String)

    @Query("SELECT * FROM thursday_table")
    fun getAllThursday(): List<ThursdayEntity>

    @Query("SELECT DISTINCT plan, * FROM thursday_table GROUP BY plan")
    fun getThursdayPlans(): List<ThursdayEntity>

    @Query("SELECT * FROM thursday_table WHERE plan = :planName")
    fun getThursdayByPlan(planName: String): List<ThursdayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllThursday(news: List<ThursdayEntity>)

    @Delete
    fun deleteAllThursday(news: List<ThursdayEntity>)

    @Query("DELETE FROM thursday_table WHERE plan = :planName")
    fun deleteThursday(planName: String)

    @Query("SELECT * FROM friday_table")
    fun getAllFriday(): List<FridayEntity>

    @Query("SELECT DISTINCT plan, * FROM friday_table GROUP BY plan")
    fun getFridayPlans(): List<FridayEntity>

    @Query("SELECT * FROM friday_table WHERE plan = :planName")
    fun getFridayByPlan(planName: String): List<FridayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFriday(news: List<FridayEntity>)

    @Delete
    fun deleteAllFriday(news: List<FridayEntity>)

    @Query("DELETE FROM friday_table WHERE plan = :planName")
    fun deleteFriday(planName: String)

    @Query("SELECT * FROM saturday_table")
    fun getAllSaturday(): List<SaturdayEntity>

    @Query("SELECT DISTINCT plan, * FROM saturday_table GROUP BY plan")
    fun getSaturdayPlans(): List<SaturdayEntity>

    @Query("SELECT * FROM saturday_table WHERE plan = :planName")
    fun getSaturdayByPlan(planName: String): List<SaturdayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSaturday(news: List<SaturdayEntity>)

    @Delete
    fun deleteAllSaturday(news: List<SaturdayEntity>)

    @Query("DELETE FROM saturday_table WHERE plan = :planName")
    fun deleteSaturday(planName: String)

    @Query("SELECT * FROM sunday_table")
    fun getAllSunday(): List<SundayEntity>

    @Query("SELECT DISTINCT plan, * FROM sunday_table GROUP BY plan")
    fun getSundayPlans(): List<SundayEntity>

    @Query("SELECT * FROM sunday_table WHERE plan = :planName")
    fun getSundayByPlan(planName: String): List<SundayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSunday(news: List<SundayEntity>)

    @Delete
    fun deleteAllSunday(news: List<SundayEntity>)

    @Query("DELETE FROM sunday_table WHERE plan = :planName")
    fun deleteSunday(planName: String)

    @Query("SELECT * FROM nutrients_table")
    fun getAllNutrients(): List<NutrientsPlanEntity>

    @Query("SELECT DISTINCT plan, * FROM nutrients_table GROUP BY plan")
    fun getNutrientsPlans(): List<NutrientsPlanEntity>

    @Query("SELECT * FROM nutrients_table WHERE plan = :planName")
    fun getNutrientsByPlan(planName: String): List<NutrientsPlanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNutrients(news: List<NutrientsPlanEntity>)

    @Delete
    fun deleteAllNutrients(news: List<NutrientsPlanEntity>)

    @Query("DELETE FROM nutrients_table WHERE plan = :planName")
    fun deleteNutrients(planName: String)

}