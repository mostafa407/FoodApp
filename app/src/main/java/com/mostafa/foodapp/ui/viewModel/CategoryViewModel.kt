package com.mostafa.foodapp.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Result
import com.mostafa.foodapp.data.netWorking.CatergoryInterface
import com.mostafa.foodapp.data.netWorking.RetroBuilder
import com.mostafa.foodapp.data.reoisitory.CategoryRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var category = MutableLiveData<Result<Categories?>>()
    private var repo: CategoryRepositoryImp


    init {
        var apiser = RetroBuilder.getRetroBuilder().create(CatergoryInterface::class.java)
        repo = CategoryRepositoryImp(apiser)
        getCatrgory()
    }

  @SuppressLint("SuspiciousIndentation")
  fun getCatrgory()  {
      viewModelScope.launch(Dispatchers.IO) {
          val response=repo.getcat()
              category.postValue(response)

          }

      }

  }

private fun <T> MutableLiveData<T>.postValue(response: Flow<T>) {
    TODO("Not yet implemented")
}

