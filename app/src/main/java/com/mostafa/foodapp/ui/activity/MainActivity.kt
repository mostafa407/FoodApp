package com.mostafa.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.ui.viewModel.CategoryViewModel
import com.mostafa.foodapp.databinding.ActivityMainBinding
import com.mostafa.foodapp.ui.adapter.CategoryRecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModl: CategoryViewModel by viewModels()
    var category:ArrayList<Categories> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        val recyclerViewCategories=binding.recycler
        val categories = Categories.CategoryData.getCategoryData(this)
        val categoriesRecyclerView = CategoryRecyclerView(categories)
        recyclerViewCategories.adapter=categoriesRecyclerView
        recyclerViewCategories.layoutManager=GridLayoutManager(this,2)
        recyclerViewCategories.addItemDecoration(DividerItemDecoration(this,GridLayoutManager.VERTICAL))

        recyclerViewCategories.setHasFixedSize(true)



    }
}