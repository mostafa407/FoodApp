package com.mostafa.foodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding

class CategoryRecyclerView(private val categories: ArrayList<Categories>): RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    private lateinit var binding: ListItemBinding

    class CategoryViewHolder(private val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
      fun bind(categories: Categories){
        }
    }
    var catList:ArrayList<Categories> = ArrayList()
//    fun setcat(catList :ArrayList<Categories>){
//            this.catList=catList
//            notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding= ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categories=categories[position]
        holder.bind(categories)

    }
}