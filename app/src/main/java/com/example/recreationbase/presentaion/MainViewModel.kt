package com.example.recreationbase.presentaion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import com.example.recreationbase.presentaion.blogs.BlogInfoState
import com.example.recreationbase.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RecreationBaseRepository
) : ViewModel() {

    var state by mutableStateOf(BlogInfoState())
        private set

    fun onEvent(event: Event){
        when(event){
            is Event.LoadBlogs ->{
                downloadBlogs()
            }
        }
    }

    fun downloadBlogs() {
        viewModelScope.launch {
            repository.getBlogsForMainPage().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            state = state.copy(info =it)
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
    }
}