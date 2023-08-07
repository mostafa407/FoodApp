package com.mostafa.foodapp.ui.adapter

import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Meals

interface OnListItemClick {
    fun onItemClick(categories: Categories.Category)

}
interface OnListClick{
    fun onItem(meals:Meals.Meal)
}