package com.example.assignment_25.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_25.home.data.ResponseItem
import com.example.assignment_25.home.network.RestfulApiDevRetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            val result = restfulDevApiService.getAllObjects()
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}