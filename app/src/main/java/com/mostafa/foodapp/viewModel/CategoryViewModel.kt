package com.mostafa.foodapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.model.Category
import com.mostafa.foodapp.netWorking.CatergoryInterface
import com.mostafa.foodapp.netWorking.RetroBuilder
import com.mostafa.foodapp.reoisitory.CategoryRepositoryImp
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var category =MutableLiveData<ArrayList<Category>>()
    private var repo : CategoryRepositoryImp
    init {
        var apiser= RetroBuilder.getRetroBuilder().create(CatergoryInterface::class.java)
        repo= CategoryRepositoryImp(apiser)
    }

    fun getCatrgory()= viewModelScope.launch {
            val result=repo.getcat()
            if (result.isSuccessful){
               if(result.body()!=null) {
                  category.postValue(result.body())
            }
            }else{
                Log.d("here",result.message())
            }
        }
    }