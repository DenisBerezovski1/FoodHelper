package com.example.data.models.user

import com.squareup.moshi.Json

class UserResponse (
    @Json(name = "username") val username: String? = null,
    @Json(name = "spoonacularPassword") val spoonacularPassword: String? = null,
    @Json(name = "hash") val hash: String? = null
)