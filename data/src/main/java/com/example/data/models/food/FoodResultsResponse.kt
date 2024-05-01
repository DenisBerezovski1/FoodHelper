package com.example.data.models.food

import com.squareup.moshi.Json

data class FoodResultsResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "image") val image: String? = null,
    @Json(name = "imageType") val imageType: String? = null
)