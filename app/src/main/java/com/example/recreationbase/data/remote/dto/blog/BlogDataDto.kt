package com.example.recreationbase.data.remote.dto.blog

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class BlogDataDto(

    @SerialName("id") var id: Int? = null,
    @SerialName("image") var image: BlogImageDto? = BlogImageDto(),
    @SerialName("title") var title: String? = null,
    @SerialName("subtitle") var subtitle: String? = null,
    @SerialName("view") var view: Int? = null,
    @SerialName("like") var like: Int? = null,
    @SerialName("date") var date: BlogDate? = BlogDate()

)
