package com.mostafa.foodapp.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Category
import com.mostafa.foodapp.ui.viewModel.CategoryViewModel
import com.mostafa.foodapp.databinding.ActivityMainBinding
import com.mostafa.foodapp.ui.adapter.CategoryRecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModl: CategoryViewModel by viewModels()


    @SuppressLint("SuspiciousIndentation")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        val recyclerViewCategories = binding.recycler
//        val categoies=Categories.Category()
//        val categoryAdapter=CategoryRecyclerView(categoies)
        val linearManger=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        recyclerViewCategories.adapter=categoryAdapter
        recyclerViewCategories.layoutManager=linearManger
        recyclerViewCategories.setHasFixedSize(true)
        Log.d("here","helloooooooo")
        recyclerViewCategories.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                GridLayoutManager.VERTICAL
            )
        )
//        binding.recycler.adapter = adapter

        viewModl.category.observe(this@MainActivity, Observer { _ ->

                GlobalScope.launch(Dispatchers.Main) {
//                   categoryAdapter.setCategoryList(categoies)
//                        adapter.setCategoryList(categoies)
                        viewModl.getCatrgory()
                }
            })




    }
}
