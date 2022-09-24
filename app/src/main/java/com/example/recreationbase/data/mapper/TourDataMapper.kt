package com.example.recreationbase.data.mapper

import com.example.recreationbase.data.remote.dto.tours.TourDataDto
import com.example.recreationbase.domain.model.TourData

fun TourDataDto.toTourData() : TourData {
    return TourData(
        id = id,
        image = image,
        title = title,
        price = price?.price,
        currency = price?.currency,
        location = location
    )
}