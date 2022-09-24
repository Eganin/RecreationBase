package com.example.recreationbase.data.remote.dto.tours

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourDateDto(
    @SerialName("typeDate") var typeDate: String? = null,
    @SerialName("date") var date: String? = null
)
