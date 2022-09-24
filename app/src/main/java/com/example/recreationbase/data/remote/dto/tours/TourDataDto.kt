package com.example.recreationbase.data.remote.dto.tours

import com.example.recreationbase.data.remote.dto.Image
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourDataDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("image") var image: Image? = Image(),
    @SerialName("title") var title: String? = null,
    @SerialName("location") var location: String? = null,
    @SerialName("date") var date: TourDateDto? = TourDateDto(),
    @SerialName("duration") var duration: TourDurationDto? = TourDurationDto(),
    @SerialName("price") var price: TourPriceDto? = TourPriceDto(),
    @SerialName("home") var home: TourHomeDto? = TourHomeDto()
)
