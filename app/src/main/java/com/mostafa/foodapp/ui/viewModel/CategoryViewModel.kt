package com.mostafa.foodapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.netWorking.CatergoryInterface
import com.mostafa.foodapp.data.netWorking.RetroBuilder
import com.mostafa.foodapp.data.reoisitory.CategoryRepositoryImp
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var category =MutableLiveData<ArrayList<Categories>>()
    private var repo : CategoryRepositoryImp
    init {
        var apiser= RetroBuilder.getRetroBuilder().create(CatergoryInterface::class.java)
        repo= CategoryRepositoryImp(apiser)
    }

    fun getCatrgory()= viewModelScope.launch {
            val result=repo.getcat()
            if (result.isSuccessful){
               if(result.body()!=null) {
      //         category.postValue(result.body())
            }
            }else{
                Log.d("here",result.message())
            }
        }
    }