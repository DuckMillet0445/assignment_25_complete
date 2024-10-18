package com.example.assignment_25.home.network

import com.example.assignment_25.auth.LoginRequest
import com.example.assignment_25.auth.LoginResponse
import com.example.assignment_25.auth.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VuNit3213ApiService {
    @POST("{location}/auth")
    suspend fun login(@Path("location") location: String, @Body loginRequest: LoginRequest): LoginResponse

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): DashboardResponse
}