package com.example.recreationbase.data.remote.dto.blogdetail

import kotlinx.serialization.SerialName

data class BlogDetailData(
    @SerialName("id") var id: Int? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("image") var image: BlogDetailImage? = BlogDetailImage(),
    @SerialName("title") var title: String? = null,
    @SerialName("subtitle") var subtitle: String? = null,
    @SerialName("like") var like: Int? = null,
    @SerialName("date") var date: String? = null,
    @SerialName("content") var content: String? = null
)
