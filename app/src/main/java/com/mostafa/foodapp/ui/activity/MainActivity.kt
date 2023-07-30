package com.mostafa.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        viewModl.getCatrgory()

            viewModl.category.observe(this@MainActivity, Observer {
                lifecycleScope.launch (Dispatchers.Main) {
                    val categories = Categories.CategoryData.getCategoryData(this@MainActivity)
                    val categoriesRecyclerView = CategoryRecyclerView(categories)
                    val recyclerViewCategories = binding.recycler
                    recyclerViewCategories.adapter = categoriesRecyclerView
                    recyclerViewCategories.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    recyclerViewCategories.addItemDecoration(
                        DividerItemDecoration(
                            this@MainActivity,
                            GridLayoutManager.VERTICAL
                        )
                    )
                    recyclerViewCategories.setHasFixedSize(true)
                }

            })

            }
}