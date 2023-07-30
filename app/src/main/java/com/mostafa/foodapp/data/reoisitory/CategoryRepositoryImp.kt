package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.netWorking.CatergoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CategoryRepositoryImp(private val api: CatergoryInterface): CategoryRepository {
    override suspend fun getcat()=
        withContext(Dispatchers.IO){
        api.getcat()
        }
    }

