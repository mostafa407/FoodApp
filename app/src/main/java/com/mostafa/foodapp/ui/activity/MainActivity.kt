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
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.netWorking.ApiHelper
import com.mostafa.foodapp.data.netWorking.RetrofitBuilder
import com.mostafa.foodapp.ui.viewModel.CategoryViewModel
import com.mostafa.foodapp.databinding.ActivityMainBinding
import com.mostafa.foodapp.ui.adapter.CategoryRecyclerView
import com.mostafa.foodapp.ui.viewModel.CategoryViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

abstract class MainActivity() : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: CategoryViewModel

    var categoriesli: ArrayList<Categories> =ArrayList()
     val categoryRecyclerView: CategoryRecyclerView by lazy { CategoryRecyclerView() }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.recycler.adapter=categoryRecyclerView
        val linearManger=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycler.layoutManager=linearManger
        binding.recycler.setHasFixedSize(true)
        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        categoryRecyclerView.setCategoryList(categoriesli)


        viewModel = ViewModelProvider(this,CategoryViewModelFactory(
            ApiHelper(RetrofitBuilder.apiService)))[CategoryViewModel::class.java]
        viewModel.category.observe(this@MainActivity, Observer { categories ->

            Log.d("main",categories.toString())
                }
            )

}


    }

