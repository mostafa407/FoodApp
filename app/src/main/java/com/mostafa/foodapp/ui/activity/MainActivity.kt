package com.mostafa.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.viewModel.CategoryViewModel
import com.mostafa.foodapp.databinding.ActivityMainBinding
import com.mostafa.foodapp.model.Category
import com.mostafa.foodapp.ui.adapter.CategoryRecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModl:CategoryViewModel by viewModels()
    var category:ArrayList<Category> = ArrayList()
    var categoryRecyclerView:CategoryRecyclerView = CategoryRecyclerView(allData = ArrayList<Category>())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        categoryRecyclerView.setcat(category)
        val gridLayoutManager=GridLayoutManager(this,2)
        gridLayoutManager.orientation =GridLayoutManager.VERTICAL
        binding.recycler.adapter=categoryRecyclerView
        binding.recycler.layoutManager = gridLayoutManager
        binding.recycler.setHasFixedSize(true)

    }
}