package com.example.recreationbase.data.remote.dto.rooms

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RoomPriceDto(
    @SerialName("factPrice") var factPrice: Int? = null,
    @SerialName("price") var price: Int? = null,
    @SerialName("discount") var discount: String? = null,
    @SerialName("currency") var currency: String? = null,
    @SerialName("typePrice") var typePrice: String? = null
)
