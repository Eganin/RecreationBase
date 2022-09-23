package com.example.recreationbase.data.remote.dto.blog

import kotlinx.serialization.SerialName

data class BlogImageDto(
    @SerialName("sm") var sm: String? = null,
    @SerialName("md") var md: String? = null,
    @SerialName("lg") var lg: String? = null
)
