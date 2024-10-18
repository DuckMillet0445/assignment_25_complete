package com.example.assignment_25.auth

import com.squareup.moshi.Json

data class DashboardResponse(
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)