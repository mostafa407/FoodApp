package com.mostafa.foodapp.ui.viewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.reoisitory.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository:CategoryRepository):ViewModel() {
    var category = MutableLiveData<Categories>()
    init {
        getCatrgory()

    }
    fun getCatrgory() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = categoryRepository.getCat()
            if (response.isSuccessful) {
                category.postValue(response.body())
                Log.d("result", response.body().toString())
            }
        }
    }
}
