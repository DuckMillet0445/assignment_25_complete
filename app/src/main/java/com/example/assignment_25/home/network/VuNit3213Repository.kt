package com.example.assignment_25.home.network

import com.example.assignment_25.auth.Entity
import com.example.assignment_25.auth.LoginRequest
import javax.inject.Inject

// Repository for handling data operations and API interactions
class VuNit3213Repository @Inject constructor(private val apiClient: VuNit3213ApiClient) {

    // Performs login operation and returns a result with the keypass
    suspend fun login(location: String, username: String, password: String): Result<String> {
        return try {
            // Call the API service to login
            val response = apiClient.apiService.login(location, LoginRequest(username, password))

            // Return success result with keypass
            Result.success(response.keypass)
        } catch (e: Exception) {
            // Return failure with exception
            Result.failure(e)
        }
    }

    // Fetches dashboard data and returns a result with the list of entities
    suspend fun getDashboard(keypass: String): Result<List<Entity>> {
        return try {
            // Call the API service to get dashboard data
            val response = apiClient.apiService.getDashboard(keypass)
            // Return success result with entities
            Result.success(response.entities)
        } catch (e: Exception) {
            // Return result with exception
            Result.failure(e)
        }
    }
}