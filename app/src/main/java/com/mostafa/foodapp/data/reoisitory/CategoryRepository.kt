package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.model.Categories
import retrofit2.Response

interface CategoryRepository {
    suspend fun getcat() :Response<Categories>

}
