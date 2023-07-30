package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Result
import com.mostafa.foodapp.data.netWorking.CatergoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

class CategoryRepositoryImp(private val api: CatergoryInterface): CategoryRepository {
    override suspend fun getcat(): Flow<Result<Categories?>> {
        return flow {
          try {
              val result=api.getcat()
              if(result.isSuccessful){
                  emit(Result.Success(result.body()!!))
              }else{
                throw ApiExeption(result.code().toString())
              }
          }catch (e:Exception){
  //        emit(Result.Error(e.message.toString()))
          }
        }
    }
    class ApiExeption(message:String):IOException(message)

}

