package com.example.recreationbase.data.remote.dto.blog

import kotlinx.serialization.SerialName

data class BlogDate(
    @SerialName("typeDate") var typeDate: String? = null,
    @SerialName("date") var date: String? = null
)
