package com.example.recreationbase.domain.model

import com.example.recreationbase.data.remote.dto.blog.BlogImageDto

data class BlogData(
    var id: Int? = null,
    var image: BlogImageDto? = BlogImageDto(),
    var title: String? = null,
    var subtitle: String? = null,
    var view: Int? = null,
    var like: Int? = null,
    var date: String? = null
)
