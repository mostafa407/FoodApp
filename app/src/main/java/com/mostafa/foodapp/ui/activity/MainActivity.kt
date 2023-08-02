package com.mostafa.foodapp.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        var categoriesli: ArrayList<Categories.Category> = ArrayList()
        val categoryRecyclerView: CategoryRecyclerView by lazy { CategoryRecyclerView(allData = ArrayList()) }

        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            setSupportActionBar(binding.toolbar)

        val linearManger=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycler.layoutManager=linearManger
        binding.recycler.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recycler.adapter=categoryRecyclerView
        binding.recycler.setLayoutManager(linearLayoutManager)
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
                binding.recycler.adapter=categoryRecyclerView

            viewModel.category.observe(this@MainActivity, Observer { categories ->
                categoryRecyclerView.setCategoryList(categoriesli)
                Log.d("main",categories.toString())
            }
            )

        }


    }
