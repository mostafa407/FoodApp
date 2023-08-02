package com.mostafa.foodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding

class CategoryRecyclerView(allData: ArrayList<Categories>)
    : RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    var categoiesList = mutableListOf<Categories>()

    inner class CategoryViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {

    }
    fun setCategoryList(categoiesList: ArrayList<Categories>) {
        this.categoiesList = categoiesList.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = categoiesList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            DataBindingUtil.inflate<ListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        )



    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.listItemBinding.model = categoiesList[position]
    }


}






