package com.example.recreationbase.domain.model

import com.example.recreationbase.data.remote.dto.Image

data class RoomData(
    val id: Int? = null,
    var image: Image? = Image(),
    var title: String? = null,
    val price: String? = null,
    val currencyPrice: String? = null,
    var countTourist: Int? = null
)
