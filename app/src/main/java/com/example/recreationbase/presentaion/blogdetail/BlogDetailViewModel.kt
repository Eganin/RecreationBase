package com.example.recreationbase.presentaion.blogdetail

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
class BlogDetailViewModel @Inject constructor(
    private val repository: RecreationBaseRepository
) : ViewModel() {

    var state by mutableStateOf(BlogDetailState())
        private set

    fun onEvent(event: BlogDetailEvent) {
        when (event) {
            is BlogDetailEvent.LoadInfo -> {
                downloadDetailInfoForBlog(id = event.id)
            }
        }
    }

    private fun downloadDetailInfoForBlog(id: Int) {
        viewModelScope.launch {
            repository.getDetailInfoBlog(blogId = id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            state = state.copy(info = it)
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