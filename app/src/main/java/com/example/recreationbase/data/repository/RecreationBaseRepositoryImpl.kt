package com.example.recreationbase.data.repository

import com.example.recreationbase.data.mapper.toBlogData
import com.example.recreationbase.data.remote.RecreationBaseApi
import com.example.recreationbase.data.remote.dto.blog.BlogDataDto
import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailData
import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import com.example.recreationbase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RecreationBaseRepositoryImpl @Inject constructor(
    private val api: RecreationBaseApi
) : RecreationBaseRepository {
    override suspend fun getBlogsForMainPage(): Flow<Resource<List<BlogData>>> {
        return flow {
            val response = api.getBlogs().data.map { it.toBlogData() }
            bodyForDataLoading { response }
        }
    }

    override suspend fun getDetailInfoBlog(blogId: Int): Flow<Resource<BlogDetailData>> {
        return flow {
            val response = api.getDetailBlogInfo(blogId = blogId).data?.apply {
                val arrDate = date?.split("T")?.get(0)?.split("-")
                date = "${arrDate?.get(2)}.${arrDate?.get(1)}.${arrDate?.get(0)}"
            }
            response?.let {
                bodyForDataLoading { it }
            }
        }
    }

    override suspend fun getFoodsForMainPage(): Flow<Resource<List<FoodInfo>>> {
        return flow {
            val response = api.getFoods().data
            bodyForDataLoading { response }
        }
    }

    private suspend fun <T> FlowCollector<Resource<T>>.bodyForDataLoading(blockResponse: suspend () -> T) {
        emit(Resource.Loading(isLoading = true))
        val response = try {
            blockResponse()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Couldn't load data"))
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Couldn't load data"))
            null
        }

        response?.let {
            emit(
                Resource.Success(
                    data = it
                )
            )
            emit(Resource.Loading(isLoading = false))
        }
    }
}