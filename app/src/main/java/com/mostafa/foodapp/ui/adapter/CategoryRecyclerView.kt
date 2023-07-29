package com.mostafa.foodapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.foodapp.R
import com.mostafa.foodapp.model.Category

class CategoryRecyclerView(allData: ArrayList<Category>): RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var n:TextView=itemView.findViewById(R.id.txt)
        var m:TextView=itemView.findViewById(R.id.title)
        fun bind(category: Category){
            n.text=category.strCategory
            m.text=category.strCategoryDescription
        }
    }
    var catList:ArrayList<Category> = ArrayList()
    fun setcat(catList :ArrayList<Category>){
            this.catList=catList
            notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return catList.size
        }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category:Category=catList.get(position)
        holder.bind(category)

    }
}