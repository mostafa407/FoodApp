package com.mostafa.foodapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.data.model.Meals
import com.mostafa.foodapp.data.netWorking.Meals.ApiHelperMeals
import com.mostafa.foodapp.data.netWorking.Meals.RetrofitBuilderMeals
import com.mostafa.foodapp.databinding.ActivityMealsBinding
import com.mostafa.foodapp.ui.adapter.MealRecyclerView
import com.mostafa.foodapp.ui.adapter.OnListClick
import com.mostafa.foodapp.ui.adapter.OnListItemClick
import com.mostafa.foodapp.ui.viewModel.MealsViewModel
import com.mostafa.foodapp.ui.viewModel.MealsViewModelFactory

class MealsActivity : AppCompatActivity(), OnListClick {
    lateinit var binding:ActivityMealsBinding
    lateinit var viewModel:MealsViewModel

    var mealslist: ArrayList<Meals.Meal> = ArrayList()
    var   mealRecyclerView: MealRecyclerView = MealRecyclerView(mealslist)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=DataBindingUtil.setContentView(this,R.layout.activity_meals)
         setSupportActionBar(binding.toolbar)

        binding.lifecycleOwner=this
        var title= intent.extras?.getString("title")
        supportActionBar?.title=title



//        var categoriesId= intent.getStringExtra("categoriesId")
        var categoriesli: ArrayList<Meals.Meal> = ArrayList()
        mealRecyclerView.setList(categoriesli)
        val linearLayoutManager = GridLayoutManager(this,2)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclermeal.adapter=mealRecyclerView
        binding.recyclermeal.setLayoutManager(linearLayoutManager)
        binding.recyclermeal.addItemDecoration(
            DividerItemDecoration(
                this@MealsActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel = ViewModelProvider(
            this, MealsViewModelFactory(
                ApiHelperMeals(RetrofitBuilderMeals.apiServiceMeals)
            )
        )[MealsViewModel::class.java]

        viewModel.meals.observe(this, Observer { meals->
            mealRecyclerView.setList(meals.meals)


        })
        mealRecyclerView.onListClick=this
    }



    override fun onItem(meals: Meals.Meal) {
        val intent= Intent(this,DetailsActivity::class.java)
        intent.putExtra("img",meals.strMealThumb)
        startActivity(intent)
    }
}