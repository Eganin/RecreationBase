package com.example.recreationbase.presentaion.mainpage.blogs

import com.example.recreationbase.domain.model.BlogData

data class BlogState(
    val blogs: List<BlogData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
