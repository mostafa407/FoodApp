package com.mostafa.foodapp.data.netWorking

class ApiHelper (private val apiService:ApiInterface){
    suspend fun getCat() =apiService.getcat()
}