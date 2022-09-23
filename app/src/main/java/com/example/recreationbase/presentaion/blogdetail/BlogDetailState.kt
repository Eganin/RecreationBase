package com.example.recreationbase.presentaion.blogdetail

import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailData

data class BlogDetailState(
    val info : BlogDetailData?=null,
    val isLoading: Boolean = false,
    val error: String? = null
)