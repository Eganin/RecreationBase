package com.example.recreationbase.presentaion

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import com.example.recreationbase.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RecreationBaseRepository
) : ViewModel() {

    var state by mutableStateOf(InfoState())
        private set

    fun onEvent(event: Event) {
        when (event) {
            is Event.LoadBlogs -> {
                downloadBlogs()
            }

            is Event.LoadFoods -> {
                downloadFoods()
            }

            is Event.LoadRooms -> {
                downloadRooms()
            }
        }
    }

    private fun downloadRooms() {
        viewModelScope.launch {
            repository.getRoomsForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    it.forEach {
                        Log.d("EEE", it.toString())
                    }
                }
            }
        }
    }

    private fun downloadFoods() {
        viewModelScope.launch {
            repository.getFoodsForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(foods = it)
                }
            }
        }
    }

    private fun downloadBlogs() {
        viewModelScope.launch {
            repository.getBlogsForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(blogs = it)
                }
            }
        }
    }

    private fun <T> wrapperForHandlerResource(
        result: Resource<T>,
        onStateChangeSuccess: (T) -> Unit
    ) {
        when (result) {
            is Resource.Success -> {
                result.data?.let {
                    onStateChangeSuccess(it)
                }
            }

            is Resource.Error -> {
                state = state.copy(error = result.message)
            }

            is Resource.Loading -> {
                state = state.copy(isLoading = true)
            }
        }
    }
}