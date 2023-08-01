package com.mostafa.foodapp.data.reoisitory

import android.util.Log
import android.widget.Toast
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Result
import com.mostafa.foodapp.data.netWorking.CatergoryInterface
import retrofit2.Response

class CategoryRepositoryImp(private val api: CatergoryInterface): CategoryRepository {
    override suspend fun getcat(): Response<Categories> {
        val result = api.getcat()
        return result
    }
    //            if(result.isSuccessful){
//                  Result.Success(result.body()!!)
//                  Log.d("result",result.toString())
//
//              }else{
//                  Result.Error(result.errorBody().toString())
//                  Log.d("result",result.errorBody().toString())
//
//              }
//        return Result.Success(result.body()!!)
//        }
    }


