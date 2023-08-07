package com.mostafa.foodapp.data.netWorking.Meals

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderMeals{
    private const val BASE_URL="https://www.themealdb.com/"
    fun getRetrofitBuilderMeals():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiServiceMeals= getRetrofitBuilderMeals().create(ApiInterfaceMeal::class.java)
}