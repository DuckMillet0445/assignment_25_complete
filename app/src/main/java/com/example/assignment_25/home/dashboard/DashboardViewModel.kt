package com.example.assignment_25.home.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_25.auth.Entity
import com.example.assignment_25.home.network.VuNit3213Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: VuNit3213Repository
) : ViewModel() {


    private val _entities = MutableLiveData<Result<List<Entity>>>()
    val entities: LiveData<Result<List<Entity>>> = _entities


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun getDashboard(keypass: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _entities.value = repository.getDashboard(keypass)
            _isLoading.value = false
        }
    }
}