package com.example.recreationbase.data.mapper

import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDataDto

fun BlogDetailDataDto.toBlogData() : BlogDetailDataDto{
    val arrDate = date?.split("T")?.get(0)?.split("-")
    return BlogDetailDataDto(
        id=id,
        url=url,
        image=image,
        title = title,
        subtitle = subtitle,
        like = like,
        date="${arrDate?.get(2)}.${arrDate?.get(1)}.${arrDate?.get(0)}",
        content = content
    )
}