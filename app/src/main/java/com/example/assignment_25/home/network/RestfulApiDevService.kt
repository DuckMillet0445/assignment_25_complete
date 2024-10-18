package com.example.assignment_25.home.network

import com.example.assignment_25.home.data.ResponseItem
import retrofit2.http.GET

interface RestfulApiDevService {

    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>
}