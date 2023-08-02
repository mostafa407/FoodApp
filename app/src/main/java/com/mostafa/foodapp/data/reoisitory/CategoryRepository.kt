package com.mostafa.foodapp.data.reoisitory
import com.mostafa.foodapp.data.netWorking.ApiHelper

class CategoryRepository(private val api: ApiHelper) {
    suspend fun getCat() = api.getCat()
}



