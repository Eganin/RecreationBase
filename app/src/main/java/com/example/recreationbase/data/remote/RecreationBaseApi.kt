package com.example.recreationbase.data.remote

import com.example.recreationbase.data.remote.dto.blog.BlogsDto
import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetailDto
import com.example.recreationbase.data.remote.dto.food.FoodDataDto
import com.example.recreationbase.data.remote.dto.`fun`.FunDto
import com.example.recreationbase.data.remote.dto.funchild.FunChildDto
import com.example.recreationbase.data.remote.dto.places.PlacesDto
import com.example.recreationbase.data.remote.dto.rooms.RoomsDto
import com.example.recreationbase.data.remote.dto.tours.ToursDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecreationBaseApi {

    @GET("api/base-app/blog?id=117&format=card")
    suspend fun getBlogs() : BlogsDto

    @GET("api/base-app/blog-info?id=117")
    suspend fun getDetailBlogInfo(
        @Query("blog_id") blogId: Int
    ) : BlogDetailDto

    @GET("api/base-app/fun?id=117&type=food")
    suspend fun getFoods() : FoodDataDto

    @GET("api/base-app/rooms?id=117")
    suspend fun getRooms() : RoomsDto

    @GET("api/base-app/fun?id=117&type=fun")
    suspend fun getFun(): FunDto

    @GET("api/base-app/fun?id=117&type=child")
    suspend fun getFunForChilds() : FunChildDto

    @GET("api/base-app/tours?id=117")
    suspend fun getTours() : ToursDto

    @GET("api/base-app/fun?id=117&type=place")
    suspend fun getPlaces() : PlacesDto

    companion object{
        const val BASE_URL = "https://rsttur.ru/"
    }
}