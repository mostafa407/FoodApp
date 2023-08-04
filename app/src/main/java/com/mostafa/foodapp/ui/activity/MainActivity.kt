package com.mostafa.foodapp.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.netWorking.ApiHelper
import com.mostafa.foodapp.data.netWorking.RetrofitBuilder
import com.mostafa.foodapp.databinding.ActivityMainBinding
import com.mostafa.foodapp.ui.adapter.CategoryRecyclerView
import com.mostafa.foodapp.ui.viewModel.CategoryViewModel
import com.mostafa.foodapp.ui.viewModel.CategoryViewModelFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CategoryViewModel


    var categorieslist: ArrayList<Categories.Category> = ArrayList()
    var   categoryRecyclerView:CategoryRecyclerView = CategoryRecyclerView(categorieslist)
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.lifecycleOwner = this

        var categoriesli: ArrayList<Categories.Category> = ArrayList()
        binding.progressBar.visibility = View.GONE
        categoryRecyclerView.setList(categoriesli)
        val linearLayoutManager = GridLayoutManager(this,2)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recycler.adapter=categoryRecyclerView
        binding.recycler.setLayoutManager(linearLayoutManager)
        Log.d("TEST1","${binding.recycler}")

        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel = ViewModelProvider(
            this, CategoryViewModelFactory(
                ApiHelper(RetrofitBuilder.apiService)
            )
        )[CategoryViewModel::class.java]
        viewModel.category.observe(this@MainActivity, Observer { categories ->
            categoryRecyclerView.setList(categories.categories)
            Log.d("main",categories.toString())
        }
        )

    }


}