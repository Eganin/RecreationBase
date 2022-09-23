package com.example.recreationbase.presentaion.blogs

import android.util.Log
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


    fun downloadData() {
        viewModelScope.launch {
            repository.getDetailInfoBlog(blogId = 233).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {

                            Log.d("EEE", it.toString())

                        }
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }
                }
            }
        }
    }
}