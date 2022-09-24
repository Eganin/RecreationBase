package com.example.recreationbase.data.remote.dto.tours

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourPriceDto(
    @SerialName("factPrice") var factPrice: Int? = null,
    @SerialName("price") var price: Int? = null,
    @SerialName("currency") var currency: String? = null,
    @SerialName("typePrice") var typePrice: String? = null
)
