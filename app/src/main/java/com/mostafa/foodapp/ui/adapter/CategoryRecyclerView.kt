package com.mostafa.foodapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding

class CategoryRecyclerView(var list:ArrayList<Categories.Category>)
    : RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    fun SetCategoryList(lists : ArrayList<Categories.Category>) {
        this.list = lists
        notifyDataSetChanged()
    }
    class CategoryViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {
        fun bind(item:Categories.Category){
            listItemBinding.model=item
            Glide.with(itemView.context).asBitmap().load(item.strCategoryThumb).into(listItemBinding.strCategoryThumb)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        Log.d("onCreateView", "INHOLDERcreate")

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)


    }
//    fun setCategoryList(categoiesList: ArrayList<Categories>) {
//        this.categoiesList = categoiesList.toMutableList()
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        Log.d("COUNT",".getItemCountcalled ${list.size}")

        return   list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Log.d("ADAPTER", "INBINDfunc $holder")

//       holder.listItemBinding.model = list[position]
        holder.bind(list[position])



    }


}