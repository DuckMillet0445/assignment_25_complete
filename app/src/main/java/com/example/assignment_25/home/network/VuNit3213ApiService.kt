package com.example.assignment_25.home.network

import com.example.assignment_25.auth.LoginRequest
import com.example.assignment_25.auth.LoginResponse
import com.example.assignment_25.auth.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Interface defining API endpoints for VuNit3213
interface VuNit3213ApiService {

    // Endpoint for user login
    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String, // Dynamic path segment for location
        @Body loginRequest: LoginRequest // Request body containing login details
    ): LoginResponse // Response containing login result

    // Endpoint for fetching dashboard data
    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String // Dynamic path segment for keypass
    ): DashboardResponse // Response containing dashboard data
}