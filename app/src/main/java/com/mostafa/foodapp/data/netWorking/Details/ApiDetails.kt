package com.mostafa.foodapp.data.netWorking.Details

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object DetailsRetrofit{
    private const val BASE_URL="https://www.themealdb.com/"
    fun getRetrofitBuilderDetails():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
    val apiDetails= getRetrofitBuilderDetails().create(ApiIDetails::class.java)
}