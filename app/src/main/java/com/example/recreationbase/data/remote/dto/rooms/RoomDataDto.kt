package com.example.recreationbase.data.remote.dto.rooms

import com.example.recreationbase.data.remote.dto.Image
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RoomDataDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("image") var image: Image? = Image(),
    @SerialName("title") var title: String? = null,
    @SerialName("date") var date: RoomDateDto? = RoomDateDto(),
    @SerialName("duration") var duration: DurationReservationDto? = DurationReservationDto(),
    @SerialName("price") var price: RoomPriceDto? = RoomPriceDto(),
    @SerialName("countTourist") var countTourist: Int? = null,
    @SerialName("type") var type: String? = null
)
