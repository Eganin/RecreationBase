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

            is Event.LoadFun -> {
                downloadFun()
            }

            is Event.LoadFunChild -> {
                downloadChildFun()
            }

            is Event.LoadTours -> {
                downloadTours()
            }

            is Event.LoadPlaces -> {
                downloadPlaces()
            }
        }
    }

    private fun downloadPlaces() {
        viewModelScope.launch {
            repository.getPlacesForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(places = it)
                    it.forEach {
                        Log.d("EEE", it.toString())
                    }
                }
            }
        }
    }

    private fun downloadTours() {
        viewModelScope.launch {
            repository.getToursForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(tours = it)
                }
            }
        }
    }

    private fun downloadChildFun() {
        viewModelScope.launch {
            repository.getFunChildForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(childFun = it)
                }
            }
        }
    }

    private fun downloadFun() {
        viewModelScope.launch {
            repository.getFunForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(funs = it)
                }
            }
        }
    }

    private fun downloadRooms() {
        viewModelScope.launch {
            repository.getRoomsForMainPage().collect { result ->
                wrapperForHandlerResource(result = result) {
                    state = state.copy(rooms = it)
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