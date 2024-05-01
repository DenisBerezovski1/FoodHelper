package com.example.data.models.instructions

import com.squareup.moshi.Json

data class InstructionsResponse(
    @Json(name = "steps") val steps: List<InstructionStepsResponse>? = null
)