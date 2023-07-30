package com.mostafa.foodapp.data.netWorking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroBuilder {
    companion object{
        private const val Base_Url= "https://www.themealdb.com/api/json/v1/1/"
         fun getRetroBuilder():Retrofit {
          return  Retrofit.Builder()
              .baseUrl(Base_Url)
              .addConverterFactory(GsonConverterFactory.create())
              .build()

            }

    }
}