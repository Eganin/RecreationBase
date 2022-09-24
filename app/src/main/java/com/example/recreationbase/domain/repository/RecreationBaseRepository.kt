package com.example.recreationbase.domain.repository

import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDataDto
import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.util.Resource
import kotlinx.coroutines.flow.Flow

interface RecreationBaseRepository {

    suspend fun getBlogsForMainPage() : Flow<Resource<List<BlogData>>>

    suspend fun getDetailInfoBlog(blogId : Int) : Flow<Resource<BlogDetailDataDto>>

    suspend fun getFoodsForMainPage() : Flow<Resource<List<FoodInfo>>>
}