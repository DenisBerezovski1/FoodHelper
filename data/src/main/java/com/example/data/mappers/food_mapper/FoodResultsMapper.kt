package com.example.data.mappers.food_mapper

import com.example.data.db.food.BreakfastEntity
import com.example.data.db.food.BrunchEntity
import com.example.data.db.food.DinnerEntity
import com.example.data.db.food.LunchEntity
import com.example.data.models.food.FoodResultsResponse
import javax.inject.Inject

class FoodResultsMapper @Inject constructor() {
    operator fun invoke(foodResultsResponse: FoodResultsResponse) = with(foodResultsResponse) {
        BreakfastEntity(
            id = foodResultsResponse.id ?: 0,
            title = foodResultsResponse.title ?: "",
            image = foodResultsResponse.image ?: "",
            imageType = foodResultsResponse.imageType ?: ""
        )
    }

    fun toBrunchEntity(foodResultsResponse: FoodResultsResponse) = with(foodResultsResponse) {
        BrunchEntity(
            id = foodResultsResponse.id ?: 0,
            title = foodResultsResponse.title ?: "",
            image = foodResultsResponse.image ?: "",
            imageType = foodResultsResponse.imageType ?: ""
        )
    }

    fun toLunchEntity(foodResultsResponse: FoodResultsResponse) = with(foodResultsResponse) {
        LunchEntity(
            id = foodResultsResponse.id ?: 0,
            title = foodResultsResponse.title ?: "",
            image = foodResultsResponse.image ?: "",
            imageType = foodResultsResponse.imageType ?: ""
        )
    }

    fun toDinnerEntity(foodResultsResponse: FoodResultsResponse) = with(foodResultsResponse) {
        DinnerEntity(
            id = foodResultsResponse.id ?: 0,
            title = foodResultsResponse.title ?: "",
            image = foodResultsResponse.image ?: "",
            imageType = foodResultsResponse.imageType ?: ""
        )
    }
}