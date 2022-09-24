package com.example.recreationbase.data.remote.dto.tours

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourDurationDto(
    @SerialName("hour" ) var hour : Int? = null
)
