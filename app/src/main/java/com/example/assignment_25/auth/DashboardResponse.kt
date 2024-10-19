package com.example.assignment_25.auth

import com.squareup.moshi.Json

// Data class representing the response from dashboard API
data class DashboardResponse(
    // List of entities returned by the API
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)