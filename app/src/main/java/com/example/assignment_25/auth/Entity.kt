package com.example.assignment_25.auth

import com.squareup.moshi.Json
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Data class representing an entity, which is Parcelable for Android inter-process communication
@Parcelize
data class Entity(
    // names of the properties, nullable
    @Json(name = "dishName") val dishName: String? = null,
    @Json(name = "origin") val origin: String? = null,
    @Json(name = "mainIngredient") val mainIngredient: String? = null,
    @Json(name = "mealType") val mealType: String? = null,
    @Json(name = "description") val description: String? = null
) : Parcelable
