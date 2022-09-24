package com.example.recreationbase.data.remote.dto.rooms

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class DurationReservationDto(
    @SerialName("night" ) var night : Int? = null
)
