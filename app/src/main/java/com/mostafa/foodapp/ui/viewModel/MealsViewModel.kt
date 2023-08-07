package com.mostafa.foodapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.data.model.Meals
import com.mostafa.foodapp.data.reoisitory.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsViewModel(private val mealsRepository: MealsRepository):ViewModel() {
var meals= MutableLiveData<Meals>()
    init {
        getMeals()
    }
    fun getMeals(){
        viewModelScope.launch (Dispatchers.IO){
            val response=mealsRepository.getmeal()
            if (response.isSuccessful){
                meals.postValue(response.body())
                Log.d("resul",response.body().toString())

            }
        }
    }
}
