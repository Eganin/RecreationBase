package com.example.recreationbase.data.remote.dto.rooms

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RoomDateDto(
    @SerialName("typeDate") var typeDate: String? = null
)
