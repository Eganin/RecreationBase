package com.example.recreationbase.presentaion.mainpage

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import com.example.recreationbase.presentaion.mainpage.blogs.BlogState
import com.example.recreationbase.presentaion.mainpage.foods.FoodState
import com.example.recreationbase.presentaion.mainpage.funchild.ChildFunState
import com.example.recreationbase.presentaion.mainpage.funs.FunState
import com.example.recreationbase.presentaion.mainpage.places.PlaceState
import com.example.recreationbase.presentaion.mainpage.rooms.RoomState
import com.example.recreationbase.presentaion.mainpage.tours.TourState
import com.example.recreationbase.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RecreationBaseRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getFoodDetailInfo(id = 115).collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        Log.d("EEE", it.toString())
                    },
                    onLoading = { placeState = placeState.copy(isLoading = true) },
                    onError = {
                        placeState = placeState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    var placeState by mutableStateOf(PlaceState())
        private set
    var blogState by mutableStateOf(BlogState())
        private set
    var foodState by mutableStateOf(FoodState())
        private set
    var funChildState by mutableStateOf(ChildFunState())
        private set
    var funState by mutableStateOf(FunState())
        private set
    var roomState by mutableStateOf(RoomState())
        private set
    var tourState by mutableStateOf(TourState())
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
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        placeState = placeState.copy(places = it, isLoading = false)
                    },
                    onLoading = { placeState = placeState.copy(isLoading = true) },
                    onError = {
                        placeState = placeState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadTours() {
        viewModelScope.launch {
            repository.getToursForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        tourState = tourState.copy(tours = it, isLoading = false)
                    },
                    onLoading = { tourState = tourState.copy(isLoading = true) },
                    onError = {
                        tourState = tourState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadChildFun() {
        viewModelScope.launch {
            repository.getFunChildForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        funChildState = funChildState.copy(childFun = it, isLoading = false)
                    },
                    onLoading = { funChildState = funChildState.copy(isLoading = true) },
                    onError = {
                        funChildState =
                            funChildState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadFun() {
        viewModelScope.launch {
            repository.getFunForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        funState = funState.copy(funs = it, isLoading = false)
                    },
                    onLoading = { funState = funState.copy(isLoading = true) },
                    onError = {
                        funState = funState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadRooms() {
        viewModelScope.launch {
            repository.getRoomsForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        roomState = roomState.copy(rooms = it, isLoading = false)
                    },
                    onLoading = { roomState = roomState.copy(isLoading = true) },
                    onError = {
                        roomState = roomState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadFoods() {
        viewModelScope.launch {
            repository.getFoodsForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        foodState = foodState.copy(foods = it, isLoading = false)
                    },
                    onLoading = { foodState = foodState.copy(isLoading = true) },
                    onError = {
                        foodState = foodState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun downloadBlogs() {
        viewModelScope.launch {
            repository.getBlogsForMainPage().collect { result ->
                wrapperForHandlerResource(
                    result = result,
                    onStateChangeSuccess = {
                        blogState = blogState.copy(blogs = it, isLoading = false)
                    },
                    onLoading = { blogState = blogState.copy(isLoading = true) },
                    onError = {
                        blogState = blogState.copy(isLoading = false, error = result.message)
                    }
                )
            }
        }
    }

    private fun <T> wrapperForHandlerResource(
        result: Resource<T>,
        onStateChangeSuccess: (T) -> Unit,
        onLoading: () -> Unit,
        onError: () -> Unit,
    ) {
        when (result) {
            is Resource.Success -> {
                result.data?.let {
                    onStateChangeSuccess(it)
                }
            }

            is Resource.Error -> {
                onError()
            }

            is Resource.Loading -> {
                onLoading()
            }
        }
    }
}