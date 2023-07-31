package com.mostafa.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.reoisitory.CategoryRepository
import com.mostafa.foodapp.data.reoisitory.CategoryRepositoryImp
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
    var category:ArrayList<Categories> = ArrayList()
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        val recyclerViewCategories = binding.recycler
        recyclerViewCategories.setHasFixedSize(true)

        val categories = Categories.CategoryData.getCategoryData(this@MainActivity)
        val categoriesRecyclerView = CategoryRecyclerView(categories)
        var gridLayoutManager=GridLayoutManager(this,2)
        gridLayoutManager.orientation=GridLayoutManager.VERTICAL
        recyclerViewCategories.layoutManager=gridLayoutManager
        recyclerViewCategories.adapter = categoriesRecyclerView

        recyclerViewCategories.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                GridLayoutManager.VERTICAL
            )
        )


            viewModl.category.observe(this@MainActivity, Observer {category ->
                GlobalScope.launch(Dispatchers.Main) {
                    viewModl.getCatrgory()
              

                }
            })
    }
}
