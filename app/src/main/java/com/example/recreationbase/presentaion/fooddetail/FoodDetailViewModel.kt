package com.example.recreationbase.presentaion.fooddetail

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
class FoodDetailViewModel @Inject constructor(
    private val repository: RecreationBaseRepository
) : ViewModel() {

    var state by mutableStateOf(FoodDetailState())
        private set

    fun onEvent(event  :FoodDetailEvent){
        when(event){
            is FoodDetailEvent.LoadInfo ->{
                downloadDetailInfoForFood(id=event.id)
            }
        }
    }

    private fun downloadDetailInfoForFood(id : Int){
        viewModelScope.launch {
            repository.getFoodDetailInfo(id=id).collect{ result ->
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