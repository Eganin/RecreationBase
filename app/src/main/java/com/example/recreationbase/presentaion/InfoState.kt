package com.example.recreationbase.presentaion

import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.domain.model.RoomData

data class InfoState(
    val blogs: List<BlogData> = emptyList(),
    val foods : List<FoodInfo> = emptyList(),
    val rooms : List<RoomData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
