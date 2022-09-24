package com.example.recreationbase.data.remote.dto.tours

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ToursDto(
    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("time") var time: String? = null,
    @SerialName("data") var data: ArrayList<TourDataDto> = arrayListOf()
)
