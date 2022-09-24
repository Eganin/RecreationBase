package com.example.recreationbase.presentaion.mainpage.rooms

import com.example.recreationbase.domain.model.RoomData

data class RoomState (
    val rooms : List<RoomData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
