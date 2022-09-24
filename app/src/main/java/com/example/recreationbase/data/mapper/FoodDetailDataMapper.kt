package com.example.recreationbase.data.mapper

import com.example.recreationbase.data.remote.dto.fooddetail.FoodDetailDataDto
import com.example.recreationbase.domain.model.FoodDetailData

fun FoodDetailDataDto.toFoodDetailData(): FoodDetailData {

    val newWorkingHours = mutableListOf<Pair<String, String>>()

    workingHours?.forEach { data ->
        data.days.forEach {
            val pair = getNameWeekday(number = it) to data.from + " - " + data.to
            newWorkingHours.add(pair)
        }
    }

    return FoodDetailData(
        id = id,
        title = title,
        subtitle = subtitle,
        description = description,
        address = address,
        phone = contact?.phone,
        close = close,
        images = images,
        workingHours = newWorkingHours
    )
}

private fun getNameWeekday(number: Int) =
    when (number) {
        1 -> "Понедельник"
        2 -> "Вторник"
        3 -> "Среда"
        4 -> "Четверг"
        5 -> "Пятница"
        6 -> "Суббота"
        else -> "Воскресенье"
    }
