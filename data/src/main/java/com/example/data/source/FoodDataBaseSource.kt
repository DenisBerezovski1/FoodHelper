package com.example.data.source

import com.example.data.db.food.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoodDataBaseSource @Inject constructor(
    private val foodDao: FoodDao
) {
    suspend fun getAllBreakfast() = withContext(Dispatchers.IO) {
        foodDao.getAllBreakfast()
    }

    suspend fun insertAllBreakfast(news: List<BreakfastEntity>) = withContext(Dispatchers.IO) {
        foodDao.insertAllBreakfast(news)
    }

    suspend fun deleteAllBreakfast(news: List<BreakfastEntity>) = withContext(Dispatchers.IO) {
        foodDao.deleteAllBreakfast(news)
    }

    suspend fun getAllBrunch() = withContext(Dispatchers.IO) {
        foodDao.getAllBrunch()
    }

    suspend fun insertAllBrunch(news: List<BrunchEntity>) = withContext(Dispatchers.IO) {
        foodDao.insertAllBrunch(news)
    }

    suspend fun deleteAllBrunch(news: List<BrunchEntity>) = withContext(Dispatchers.IO) {
        foodDao.deleteAllBrunch(news)
    }

    suspend fun getAllLunch() = withContext(Dispatchers.IO) {
        foodDao.getAllLunch()
    }

    suspend fun insertAllLunch(news: List<LunchEntity>) = withContext(Dispatchers.IO) {
        foodDao.insertAllLunch(news)
    }

    suspend fun deleteAllLunch(news: List<LunchEntity>) = withContext(Dispatchers.IO) {
        foodDao.deleteAllLunch(news)
    }

    suspend fun getAllDinner() = withContext(Dispatchers.IO) {
        foodDao.getAllDinner()
    }

    suspend fun insertAllDinner(news: List<DinnerEntity>) = withContext(Dispatchers.IO) {
        foodDao.insertAllDinner(news)
    }

    suspend fun deleteAllDinner(news: List<DinnerEntity>) = withContext(Dispatchers.IO) {
        foodDao.deleteAllDinner(news)
    }
}