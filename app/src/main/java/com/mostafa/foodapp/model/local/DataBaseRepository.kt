package com.mostafa.foodapp.model.local

import com.mostafa.foodapp.model.Category

interface DataBaseRepository {
    suspend fun getcat():ArrayList<Category>
}