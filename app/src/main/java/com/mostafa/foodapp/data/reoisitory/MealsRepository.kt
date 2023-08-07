package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.netWorking.Meals.ApiHelperMeals

class MealsRepository(val api:ApiHelperMeals) {
    suspend fun getmeal()=api.getmeal()
}