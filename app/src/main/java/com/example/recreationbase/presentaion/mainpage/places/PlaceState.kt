package com.example.recreationbase.presentaion.mainpage.places

import com.example.recreationbase.data.remote.dto.places.PlaceDataDto

data class PlaceState(
    val places : List<PlaceDataDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
