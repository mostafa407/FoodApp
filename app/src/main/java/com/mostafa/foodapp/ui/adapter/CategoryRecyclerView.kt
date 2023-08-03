package com.mostafa.foodapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding

class CategoryRecyclerView(var categories:ArrayList<Categories>)
    : RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {

   class CategoryViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)


    }
//    fun setCategoryList(categoiesList: ArrayList<Categories>) {
//        this.categoiesList = categoiesList.toMutableList()
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        Log.d("COUNT",".getItemCountcalled ${categories.size}")

     return   categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.listItemBinding.model = categories[position]
    }


}






