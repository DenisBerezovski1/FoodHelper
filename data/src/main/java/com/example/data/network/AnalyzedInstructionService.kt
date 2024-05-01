package com.example.data.network

import com.example.data.models.instructions.InstructionsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnalyzedInstructionService {
    @GET("recipes/{id}/analyzedInstructions")
    suspend fun getInstruction(
        @Path("id") id: String,
        @Query("apiKey") token: String
    ): List<InstructionsResponse>
}