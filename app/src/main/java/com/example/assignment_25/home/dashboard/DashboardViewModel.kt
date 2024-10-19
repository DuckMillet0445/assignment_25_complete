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
    //Repository for data operations
    private val repository: VuNit3213Repository
) : ViewModel() {


    // LiveData holding the result of entity data
    private val _entities = MutableLiveData<Result<List<Entity>>>()
    val entities: LiveData<Result<List<Entity>>> = _entities


    // LiveData indicating loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    // Function to fetch dashboard data using a keypass
    fun getDashboard(keypass: String) {
        viewModelScope.launch {
            // set loading state to true
            _isLoading.value = true
            // fetch data from the repository
            _entities.value = repository.getDashboard(keypass)
            // Set loading state to false
            _isLoading.value = false
        }
    }
}
