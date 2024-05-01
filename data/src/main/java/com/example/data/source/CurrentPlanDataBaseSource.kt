package com.example.data.source

import com.example.data.db.current_plan.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrentPlanDataBaseSource @Inject constructor(
    private val currentPlanDao: CurrentPlanDao
) {
    suspend fun getAllMonday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllMonday()
    }

    suspend fun insertAllMonday(news: List<MondayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllMonday(news)
    }

    suspend fun deleteAllMonday(news: List<MondayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllMonday(news)
    }

    suspend fun getAllTuesday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllTuesday()
    }

    suspend fun insertAllTuesday(news: List<TuesdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllTuesday(news)
    }

    suspend fun deleteAllTuesday(news: List<TuesdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllTuesday(news)
    }

    suspend fun getAllWednesday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllWednesday()
    }

    suspend fun insertAllWednesday(news: List<WednesdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllWednesday(news)
    }

    suspend fun deleteAllWednesday(news: List<WednesdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllWednesday(news)
    }

    suspend fun getAllThursday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllThursday()
    }

    suspend fun insertAllThursday(news: List<ThursdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllThursday(news)
    }

    suspend fun deleteAllThursday(news: List<ThursdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllThursday(news)
    }

    suspend fun getAllFriday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllFriday()
    }

    suspend fun insertAllFriday(news: List<FridayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllFriday(news)
    }

    suspend fun deleteAllFriday(news: List<FridayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllFriday(news)
    }

    suspend fun getAllSaturday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllSaturday()
    }

    suspend fun insertAllSaturday(news: List<SaturdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllSaturday(news)
    }

    suspend fun deleteAllSaturday(news: List<SaturdayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllSaturday(news)
    }

    suspend fun getAllSunday() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllSunday()
    }

    suspend fun insertAllSunday(news: List<SundayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllSunday(news)
    }

    suspend fun deleteAllSunday(news: List<SundayCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllSunday(news)
    }

    suspend fun getAllNutrients() = withContext(Dispatchers.IO) {
        currentPlanDao.getAllNutrients()
    }

    suspend fun insertAllNutrients(news: NutrientsCurrentEntity) = withContext(Dispatchers.IO) {
        currentPlanDao.insertAllNutrients(news)
    }

    suspend fun deleteAllNutrients(news: List<NutrientsCurrentEntity>) = withContext(Dispatchers.IO) {
        currentPlanDao.deleteAllNutrients(news)
    }
}