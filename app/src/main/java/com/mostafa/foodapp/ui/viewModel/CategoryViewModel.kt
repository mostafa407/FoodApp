package com.mostafa.foodapp.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var category = MutableLiveData<Categories>()
    private var repo: CategoryRepositoryImp


    init {
        repo = CategoryRepositoryImp(apiser)
    }

    @SuppressLint("SuspiciousIndentation")
    fun getCatrgory() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getcat()

            if (response.isSuccessful) {
                category.postValue(response.body())
                Log.d("result", response.body()!!.categories.size.toString())
            }

        }

    }

}
