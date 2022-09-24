package com.example.recreationbase.data.remote.dto.tours

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourBaseDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("url") var url: String? = null
)
