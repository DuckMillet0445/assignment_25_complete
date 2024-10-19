package com.example.assignment_25.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_25.home.network.VuNit3213Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    // repository for handling login data operations
    private val repository: VuNit3213Repository
) : ViewModel() {


    // LiveData for login result, encapsulated with a backing property
    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult


    // LiveData for loading state, encapsulated with a backing property
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Function to perform login operation
    fun login(location: String, username: String, password: String) {
        viewModelScope.launch {
            // set loading state to true
            _isLoading.value = true
            // Attempt login and post result
            _loginResult.value = repository.login(location, username, password)
            // set loading state to false
            _isLoading.value = false
        }
    }
}
