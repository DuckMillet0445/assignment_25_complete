package com.example.assignment_25.auth

import com.squareup.moshi.Json

// Data class representing a login response from the server
data class LoginResponse(
    // The key or token received after a successful login
    @Json(name = "keypass") val keypass: String
)