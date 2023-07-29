package com.mostafa.foodapp.netWorking

import com.mostafa.foodapp.model.Category
import retrofit2.Response
import retrofit2.http.GET

interface CatergoryInterface {
    @GET("categories")
    suspend fun getcat():Response<ArrayList<Category>>
}