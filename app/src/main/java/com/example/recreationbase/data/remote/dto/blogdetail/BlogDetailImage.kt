package com.example.recreationbase.data.remote.dto.blogdetail

import kotlinx.serialization.SerialName

data class BlogDetailImage(
    @SerialName("sm") var sm: String? = null,
    @SerialName("md") var md: String? = null,
    @SerialName("lg") var lg: String? = null
)
