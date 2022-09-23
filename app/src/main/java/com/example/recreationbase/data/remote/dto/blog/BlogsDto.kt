package com.example.recreationbase.data.remote.dto.blog

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class BlogsDto(
    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("time") var time: String? = null,
    @SerialName("data") var data: List<BlogDataDto> = emptyList()
)
