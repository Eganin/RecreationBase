package com.example.recreationbase.data.remote.dto.places

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class PlacesDto(

    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("time") var time: String? = null,
    @SerialName("data") var data: List<PlaceDataDto> = emptyList()

)
