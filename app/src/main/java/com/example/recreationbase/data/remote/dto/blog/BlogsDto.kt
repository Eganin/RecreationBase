package com.example.recreationbase.data.remote.dto.blog

import kotlinx.serialization.SerialName


data class BlogsDto(
    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("data") var data: List<BlogDataDto> = emptyList()
)
