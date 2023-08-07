package com.mostafa.foodapp.data.netWorking.Categories

import com.mostafa.foodapp.data.model.Categories

class ApiHelper (private val apiService: ApiInterface){
    suspend fun getCat() =apiService.getcat()
}