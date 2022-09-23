package com.example.recreationbase.presentaion.blogs

import com.example.recreationbase.data.remote.dto.blog.BlogDataDto
import com.example.recreationbase.domain.model.BlogData

data class BlogInfoState(
    val info: List<BlogData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
