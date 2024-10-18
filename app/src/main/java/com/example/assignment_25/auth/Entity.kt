package com.example.assignment_25.auth

import com.squareup.moshi.Json
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
    @Json(name = "property1") val property1: String,
    @Json(name = "property2") val property2: String,
    @Json(name = "description") val description: String
) : Parcelable
