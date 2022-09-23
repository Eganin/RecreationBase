package com.example.recreationbase.data.remote

import com.example.recreationbase.data.remote.dto.blog.BlogsDto
import com.example.recreationbase.data.remote.dto.blogdetail.BlogDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface RecreationBaseApi {

    @GET("api/base-app/blog?id=117&format=card")
    suspend fun getBlogs() : BlogsDto

    @GET("api/base-app/blog-info?id=117")
    suspend fun getDetailBlogInfo(
        @Query("blog_id") blogId: Int
    ) : BlogDetail

    @GET("api/base-app/fun?id=117&type=food")
    suspend fun getFoods()

    @GET("api/base-app/rooms?id=117")
    suspend fun getRooms()

    @GET("api/base-app/fun?id=117&type=fun")
    suspend fun getFun()

    @GET("api/base-app/fun?id=117&type=child")
    suspend fun getFunForChilds()

    @GET("api/base-app/tours?id=117")
    suspend fun getTours()

    @GET("api/base-app/fun?id=117&type=place")
    suspend fun getPlace()

    companion object{
        const val BASE_URL = "https://rsttur.ru/"
    }
}