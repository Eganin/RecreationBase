package com.example.recreationbase.data.mapper

import com.example.recreationbase.data.remote.dto.blog.BlogDataDto
import com.example.recreationbase.domain.model.BlogData

fun BlogDataDto.toBlogData(): BlogData {
    val dateSplit = date?.date?.split(" ")?.get(0)?.split("-")
    val monthCode = dateSplit?.get(1)?.toInt() ?: Int.MAX_VALUE
    val monthName = getMonthName(codeMonth = monthCode)
    return BlogData(
        id = id,
        image = image,
        title = title,
        subtitle = subtitle,
        view = view,
        like = like,
        date = "${dateSplit?.get(2)} $monthName"
    )
}

private fun getMonthName(codeMonth: Int): String {
    return when (codeMonth) {
        1 -> "Января"
        2 -> "Февраля"
        3 -> "Марта"
        4 -> "Апреля"
        5 -> "Мая"
        6 -> "Июня"
        7 -> "Июля"
        8 -> "Августа"
        9 -> "Сентября"
        10 -> "Октября"
        11 -> "Ноября"
        12 -> "Декабря"
        else -> ""
    }
}