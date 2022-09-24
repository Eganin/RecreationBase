package com.example.recreationbase.data.remote.dto.blogdetail

import com.example.recreationbase.data.remote.dto.Image
import kotlinx.serialization.SerialName
@kotlinx.serialization.Serializable
data class BlogDetailDataDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("image") var image: Image? = Image(),
    @SerialName("title") var title: String? = null,
    @SerialName("subtitle") var subtitle: String? = null,
    @SerialName("like") var like: Int? = null,
    @SerialName("date") var date: String? = null,
    @SerialName("content") var content: String? = null
)
