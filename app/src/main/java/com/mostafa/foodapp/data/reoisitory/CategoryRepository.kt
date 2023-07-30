package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CategoryRepository {
    suspend fun getcat() :Flow<Result<Categories?>>

}
