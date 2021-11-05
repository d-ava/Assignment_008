package com.example.breakingbad.network

import com.example.assignment_008.model.Cources
import retrofit2.Response
import retrofit2.http.GET

interface CourcesApi {

    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getCources(): Response<Cources>
}