package com.mostafa.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.netWorking.Details.ApietailsHelper
import com.mostafa.foodapp.data.netWorking.Details.DetailsRetrofit
import com.mostafa.foodapp.databinding.ActivityDetailsBinding
import com.mostafa.foodapp.ui.viewModel.DetailsViewModel
import com.mostafa.foodapp.ui.viewModel.DetailsViewModelFactory

class DetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailsBinding
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_details)
        binding.lifecycleOwner=this
        var name= intent.extras?.getString("img")


        viewModel = ViewModelProvider(
            this, DetailsViewModelFactory(
                ApietailsHelper(DetailsRetrofit.apiDetails)
            )
        )[DetailsViewModel::class.java]
        viewModel.detail.observe(this@DetailsActivity, Observer {details->

            binding.Category.text=details.meals[0].strCategory
            binding.area.text=details.meals[0].strArea
            Glide.with(this).asBitmap().load(details.meals[0].strMealThumb).into(binding.imgDetails)
            binding.Ingredient1.text=details.meals[0].strIngredient1
            binding.Ingredient2.text=details.meals[0].strIngredient2
            binding.Ingredient3.text=details.meals[0].strIngredient3
            binding.strInstructions.text=details.meals[0].strInstructions


            Log.d("outt",details.toString())
        })

    }
}