package com.example.recreationbase.domain.repository

import com.example.recreationbase.data.remote.dto.blog.BlogDataDto
import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailData
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.util.Resource
import kotlinx.coroutines.flow.Flow

interface RecreationBaseRepository {

    suspend fun getBlogsForMainPage() : Flow<Resource<List<BlogData>>>

    suspend fun getDetailInfoBlog(blogId : Int) : Flow<Resource<BlogDetailData>>
}