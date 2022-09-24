package com.example.recreationbase.domain.repository

import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDataDto
import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.data.remote.dto.`fun`.FunDataDto
import com.example.recreationbase.data.remote.dto.funchild.FunChildDataDto
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.domain.model.RoomData
import com.example.recreationbase.domain.model.TourData
import com.example.recreationbase.util.Resource
import kotlinx.coroutines.flow.Flow

interface RecreationBaseRepository {

    suspend fun getBlogsForMainPage() : Flow<Resource<List<BlogData>>>

    suspend fun getDetailInfoBlog(blogId : Int) : Flow<Resource<BlogDetailDataDto>>

    suspend fun getFoodsForMainPage() : Flow<Resource<List<FoodInfo>>>

    suspend fun getRoomsForMainPage() : Flow<Resource<List<RoomData>>>

    suspend fun getFunForMainPage() : Flow<Resource<List<FunDataDto>>>

    suspend fun getFunChildForMainPage() : Flow<Resource<List<FunChildDataDto>>>

    suspend fun getToursForMainPage() : Flow<Resource<List<TourData>>>
}