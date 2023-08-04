package com.mostafa.foodapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding
import java.util.Collections.addAll
class CategoryRecyclerView(list:ArrayList<Categories.Category>)
    : RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    class CategoryViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {
        fun bind(item:Categories.Category){

            listItemBinding.model = item
            Glide.with(itemView.context).asBitmap().load(item.strCategoryThumb)
                .into(listItemBinding.strCategoryThumb)
            listItemBinding.strCategory.text = item.strCategory
        }


    }

    var categoriesList:ArrayList<Categories.Category> = ArrayList()
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Categories.Category>){
        this.categoriesList=list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        Log.d("onCreateView", "INHOLDERcreate")

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)


    }


    override fun getItemCount(): Int {
        Log.d("COUNT",".getItemCountcalled ${categoriesList.size}")

        return   categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Log.d("ADAPTER", "INBINDfunc $holder")

//       holder.listItemBinding.model = list[position]
        holder.bind(categoriesList[position])



    }


}
