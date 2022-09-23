package com.example.recreationbase.presentaion

import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.domain.model.BlogData

data class InfoState(
    val blogs: List<BlogData> = emptyList(),
    val foods : List<FoodInfo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
