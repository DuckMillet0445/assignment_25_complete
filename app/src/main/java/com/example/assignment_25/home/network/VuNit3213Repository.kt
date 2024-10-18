package com.example.assignment_25.home.network

import com.example.assignment_25.auth.Entity
import com.example.assignment_25.auth.LoginRequest
import javax.inject.Inject

class VuNit3213Repository @Inject constructor(private val apiClient: VuNit3213ApiClient) {
    suspend fun login(location: String, username: String, password: String): Result<String> {
        return try {
            val response = apiClient.apiService.login(location, LoginRequest(username, password))
            Result.success(response.keypass)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getDashboard(keypass: String): Result<List<Entity>> {
        return try {
            val response = apiClient.apiService.getDashboard(keypass)
            Result.success(response.entities)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}