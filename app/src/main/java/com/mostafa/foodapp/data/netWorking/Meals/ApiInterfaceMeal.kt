package com.mostafa.foodapp.data.netWorking.Meals

import com.mostafa.foodapp.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterfaceMeal {
    @GET("api/json/v1/1/filter.php")
    suspend fun getmeal(@Query("c") c :String): Response<Meals>
}