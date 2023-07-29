package com.mostafa.foodapp.reoisitory

import com.mostafa.foodapp.model.Category
import com.mostafa.foodapp.model.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

interface CategoryRepository {
    suspend fun getcat() :Response<ArrayList<Category>>

}
