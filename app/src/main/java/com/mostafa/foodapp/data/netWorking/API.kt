package com.mostafa.foodapp.data.netWorking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


object RetrofitBuilder {
    private const val Base_Url = "https://www.themealdb.com/"
    fun getRetroBuilder(): Retrofit {
      return  Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiService = getRetroBuilder().create(ApiInterface::class.java)
}