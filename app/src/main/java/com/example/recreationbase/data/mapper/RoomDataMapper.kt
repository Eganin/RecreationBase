package com.example.recreationbase.data.mapper

import com.example.recreationbase.data.remote.dto.rooms.RoomDataDto
import com.example.recreationbase.domain.model.RoomData

fun RoomDataDto.toRoomData() : RoomData{
    return RoomData(
        id = id,
        image = image,
        title = title,
        price = price?.price.toString(),
        currencyPrice = price?.currency,
        countTourist = countTourist,
        discount = price?.discount
    )
}