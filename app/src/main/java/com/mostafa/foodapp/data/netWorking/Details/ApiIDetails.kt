package com.mostafa.foodapp.data.netWorking.Details

import com.mostafa.foodapp.data.model.Details
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiIDetails {
    @GET("api/json/v1/1/lookup.php")
    suspend fun getdetail(@Query("i") num: Int):Response<Details>
}