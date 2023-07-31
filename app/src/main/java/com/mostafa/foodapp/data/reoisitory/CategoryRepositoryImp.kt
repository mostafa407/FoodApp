package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Result
import com.mostafa.foodapp.data.netWorking.CatergoryInterface

class CategoryRepositoryImp(private val api: CatergoryInterface): CategoryRepository {
    override suspend fun getcat(): Result<Categories?> {
                val result=api.getcat()
              if(result.isSuccessful){
                  Result.Success(result.body()!!)
              }else{
                  Result.Error(result.errorBody().toString())
              }
        return Result.Success(result.body()!!)
        }
    }


