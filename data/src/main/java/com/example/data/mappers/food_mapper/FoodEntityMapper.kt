package com.example.data.mappers.food_mapper

import com.example.data.db.food.BreakfastEntity
import com.example.data.db.food.BrunchEntity
import com.example.data.db.food.DinnerEntity
import com.example.data.db.food.LunchEntity
import com.example.domain.models.food.FoodData
import javax.inject.Inject

class FoodEntityMapper @Inject constructor() {
    operator fun invoke(breakfastEntity: BreakfastEntity) = with(breakfastEntity) {
        FoodData(
            id = breakfastEntity.id ?: 0,
            title = breakfastEntity.title ?: "",
            image = breakfastEntity.image ?: "",
            imageType = breakfastEntity.imageType ?: ""
        )
    }

    operator fun invoke(brunchEntity: BrunchEntity) = with(brunchEntity) {
        FoodData(
            id = brunchEntity.id ?: 0,
            title = brunchEntity.title ?: "",
            image = brunchEntity.image ?: "",
            imageType = brunchEntity.imageType ?: ""
        )
    }

    operator fun invoke(lunchEntity: LunchEntity) = with(lunchEntity) {
        FoodData(
            id = lunchEntity.id ?: 0,
            title = lunchEntity.title ?: "",
            image = lunchEntity.image ?: "",
            imageType = lunchEntity.imageType ?: ""
        )
    }

    operator fun invoke(dinnerEntity: DinnerEntity) = with(dinnerEntity) {
        FoodData(
            id = dinnerEntity.id ?: 0,
            title = dinnerEntity.title ?: "",
            image = dinnerEntity.image ?: "",
            imageType = dinnerEntity.imageType ?: ""
        )
    }
}