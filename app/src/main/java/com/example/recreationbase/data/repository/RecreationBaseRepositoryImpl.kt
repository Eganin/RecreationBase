package com.example.recreationbase.data.repository

import com.example.recreationbase.data.mapper.toBlogData
import com.example.recreationbase.data.mapper.toFoodDetailData
import com.example.recreationbase.data.mapper.toRoomData
import com.example.recreationbase.data.mapper.toTourData
import com.example.recreationbase.data.remote.RecreationBaseApi
import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDataDto
import com.example.recreationbase.data.remote.dto.food.FoodInfo
import com.example.recreationbase.data.remote.dto.`fun`.FunDataDto
import com.example.recreationbase.data.remote.dto.funchild.FunChildDataDto
import com.example.recreationbase.data.remote.dto.places.PlaceDataDto
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.domain.model.FoodDetailData
import com.example.recreationbase.domain.model.RoomData
import com.example.recreationbase.domain.model.TourData
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import com.example.recreationbase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.JsonDecoder
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RecreationBaseRepositoryImpl @Inject constructor(
    private val api: RecreationBaseApi
) : RecreationBaseRepository {
    override suspend fun getBlogsForMainPage(): Flow<Resource<List<BlogData>>> =
        flow {
            bodyForDataLoading { api.getBlogs().data.map { it.toBlogData() } }
        }


    override suspend fun getDetailInfoBlog(blogId: Int): Flow<Resource<BlogDetailDataDto>> =
        flow {
            val response = api.getDetailBlogInfo(blogId = blogId).data?.toBlogData()
            response?.let {
                bodyForDataLoading { it }
            }
        }


    override suspend fun getFoodsForMainPage(): Flow<Resource<List<FoodInfo>>> =
        flow {
            bodyForDataLoading { api.getFoods().data }
        }


    override suspend fun getRoomsForMainPage(): Flow<Resource<List<RoomData>>> =
        flow {
            bodyForDataLoading { api.getRooms().data.map { it.toRoomData() } }
        }

    override suspend fun getFunForMainPage(): Flow<Resource<List<FunDataDto>>> =
        flow {
            bodyForDataLoading { api.getFun().data }
        }

    override suspend fun getFunChildForMainPage(): Flow<Resource<List<FunChildDataDto>>> =
        flow {
            bodyForDataLoading { api.getFunForChilds().data }
        }


    override suspend fun getToursForMainPage(): Flow<Resource<List<TourData>>> =
        flow {
            bodyForDataLoading { api.getTours().data.map { it.toTourData() } }
        }


    override suspend fun getPlacesForMainPage(): Flow<Resource<List<PlaceDataDto>>> =
        flow {
            bodyForDataLoading { api.getPlaces().data }
        }

    override suspend fun getFoodDetailInfo(id: Int): Flow<Resource<FoodDetailData>> =
        flow {
            val response = api.getFoodDetail(id = id).data?.toFoodDetailData()
            response?.let {
                bodyForDataLoading { it }
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
            emit(Resource.Success(data = it))

            emit(Resource.Loading(isLoading = false))
        }
    }
}