package com.example.recreationbase.presentaion.mainpage.foods

import com.example.recreationbase.data.remote.dto.food.FoodInfo

data class FoodState(
    val foods : List<FoodInfo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
