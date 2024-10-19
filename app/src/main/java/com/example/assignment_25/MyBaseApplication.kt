package com.example.assignment_25

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyBaseApplication: Application() {

    // Called when the application is starting, before any other application objects have been created
    override fun onCreate() {
        super.onCreate()
        Log.d("nit3213", "Application onCreate was called")
    }
}