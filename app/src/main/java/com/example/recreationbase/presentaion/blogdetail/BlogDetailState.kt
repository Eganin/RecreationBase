package com.example.recreationbase.presentaion.blogdetail

import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDataDto

data class BlogDetailState(
    val info : BlogDetailDataDto?=null,
    val isLoading: Boolean = false,
    val error: String? = null
)