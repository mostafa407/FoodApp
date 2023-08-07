package com.mostafa.foodapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodapp.data.netWorking.Categories.ApiHelper
import com.mostafa.foodapp.data.reoisitory.CategoryRepository

class CategoryViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {

            return CategoryViewModel(CategoryRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
