package com.example.recreationbase.data.remote.dto.blogdetail

import kotlinx.serialization.SerialName

data class BlogDetail(

    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("data") var data: BlogDetailData? = BlogDetailData()

)
