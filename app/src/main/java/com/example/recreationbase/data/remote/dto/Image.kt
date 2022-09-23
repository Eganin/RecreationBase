package com.example.recreationbase.data.remote.dto

import kotlinx.serialization.SerialName
@kotlinx.serialization.Serializable
data class Image(
    @SerialName("sm") var sm: String? = null,
    @SerialName("md") var md: String? = null,
    @SerialName("lg") var lg: String? = null
)
