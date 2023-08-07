package com.mostafa.foodapp.data.netWorking.Meals

class ApiHelperMeals(val apiInterfaceMeal: ApiInterfaceMeal) {

    suspend fun getmeal() = apiInterfaceMeal.getmeal("Beef")
}