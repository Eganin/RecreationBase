package com.example.recreationbase.data.remote.dto.blogdetail

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class BlogDetailDto(

    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("data") var data: BlogDetailDataDto? = BlogDetailDataDto()

)
