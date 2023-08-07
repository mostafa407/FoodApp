package com.mostafa.foodapp.data.reoisitory
import com.mostafa.foodapp.data.netWorking.Categories.ApiHelper

class CategoryRepository(private val api: ApiHelper) {
    suspend fun getCat() = api.getCat()
}



