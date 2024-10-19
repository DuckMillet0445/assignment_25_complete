package com.example.assignment_25.auth

import com.squareup.moshi.Json

// Data class representing a login request payload
data class LoginRequest(
    // username for login
    @Json(name = "username") val username: String,
    // password for login
    @Json(name = "password") val password: String
)