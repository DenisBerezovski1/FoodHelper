package com.example.data.models.food

import com.squareup.moshi.Json

data class FoodResponse(
    @Json(name ="results") val results: List<FoodResultsResponse>? = null
)