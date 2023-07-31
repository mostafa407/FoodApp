package com.mostafa.foodapp.data.netWorking

import com.mostafa.foodapp.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

interface CatergoryInterface {
    @GET("api/json/v1/1/categories.php")
    suspend fun getcat():Response<Categories>
}