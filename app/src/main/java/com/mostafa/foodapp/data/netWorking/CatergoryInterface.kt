package com.mostafa.foodapp.data.netWorking

import com.mostafa.foodapp.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

interface CatergoryInterface {
    @GET("categories")
    suspend fun getcat():Response<Categories>
}