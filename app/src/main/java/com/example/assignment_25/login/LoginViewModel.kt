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
    private val repository: VuNit3213Repository
) : ViewModel() {


    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun login(location: String, username: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _loginResult.value = repository.login(location, username, password)
            _isLoading.value = false
        }
    }
}