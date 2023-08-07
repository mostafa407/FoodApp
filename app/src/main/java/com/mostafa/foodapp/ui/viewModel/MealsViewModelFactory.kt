package com.mostafa.foodapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodapp.data.netWorking.Meals.ApiHelperMeals
import com.mostafa.foodapp.data.reoisitory.MealsRepository

class MealsViewModelFactory(private val apiHelperMeals: ApiHelperMeals):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealsViewModel::class.java)) {

            return MealsViewModel(MealsRepository(apiHelperMeals) ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}