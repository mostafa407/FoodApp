package com.mostafa.foodapp.data.netWorking.Categories

import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/json/v1/1/categories.php")
    suspend fun getcat():Response<Categories>

}
