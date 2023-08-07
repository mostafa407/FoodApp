package com.mostafa.foodapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodapp.data.model.Meals
import com.mostafa.foodapp.databinding.ListMealsBinding

class MealRecyclerView(mealslist: ArrayList<Meals.Meal>) : RecyclerView.Adapter<MealRecyclerView.MealsViewHolder>() {
    var onListClick:OnListClick?=null

    inner class MealsViewHolder(val listMealsBinding:ListMealsBinding) : RecyclerView.ViewHolder(listMealsBinding.root) {

        @SuppressLint("SuspiciousIndentation")
        fun bind(item:Meals.Meal){
            listMealsBinding.model=item
            Glide.with(itemView.context).asBitmap().load(item.strMealThumb)
                .into(listMealsBinding.strMealThumb)
            listMealsBinding.strMeal.text = item.strMeal
               itemView.setOnClickListener {
                   onListClick?.onItem(item)
               }
        }
    }
    var mealsList: ArrayList<Meals.Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Meals.Meal>) {
        this.mealsList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListMealsBinding.inflate(layoutInflater, parent, false)
        return MealsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(mealsList[position])
        }
    }