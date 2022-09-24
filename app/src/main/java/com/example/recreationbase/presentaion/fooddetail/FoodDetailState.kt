package com.example.recreationbase.presentaion.fooddetail

import com.example.recreationbase.domain.model.FoodDetailData

data class FoodDetailState(
    val info : FoodDetailData?=null,
    val isLoading: Boolean = false,
    val error: String? = null
)
