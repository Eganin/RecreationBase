package com.example.recreationbase.domain.model

import com.example.recreationbase.data.remote.dto.Image

data class TourData(
    var id: Int? = null,
    var image: Image? = Image(),
    var title: String? = null,
    var price: Int? = null,
    val currency: String? = null,
    val location : String?=null
)
