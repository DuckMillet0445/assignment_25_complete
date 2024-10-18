package com.example.assignment_25.auth

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)