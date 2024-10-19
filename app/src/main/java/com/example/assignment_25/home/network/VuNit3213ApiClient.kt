package com.example.assignment_25.home.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// API client for interacting with the VuNit3213 backend
class VuNit3213ApiClient {

    // Base URL for the API
    private val BASE_URL = "https://nit3213-api-h2b3-latest.onrender.com/"

    // Logging interceptor for HTTP request and response logging
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttpClient configured with the logging interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // Moshi instance for JSON serialisation/deserialization
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    // Retrofit instance configured with base URL, Moshi, and OkHttpClient
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    // API service interface for making network requests
    val apiService: VuNit3213ApiService = retrofit.create(VuNit3213ApiService::class.java)
}