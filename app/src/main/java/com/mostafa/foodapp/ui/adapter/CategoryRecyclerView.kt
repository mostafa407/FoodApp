package com.mostafa.foodapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodapp.R
import com.mostafa.foodapp.data.model.Categories
import com.mostafa.foodapp.databinding.ListItemBinding

class CategoryRecyclerView(allData: ArrayList<Categories>) :
    RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    private lateinit var binding: ListItemBinding
    var categoiesList = mutableListOf<Categories.Category>()


    fun setCategoryList(categoiesList: ArrayList<Categories.Category>) {
        this.categoiesList = categoiesList.toMutableList()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    class CategoryViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CategoryViewHolder(binding)
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categories = categoiesList[position]
        holder.binding.title.text = categories.strCategory
        Glide.with(holder.itemView.context).load(categories.strCategoryThumb)
            .into(holder.binding.strCategoryThumb)
    }

    override fun getItemCount(): Int {
        return categoiesList.size
    }
}
//    companion object {
//        @JvmStatic
//        @BindingAdapter("loadImage")
//        fun loadImage(thumbs: ImageView, url: String) {
//            Glide.with(thumbs)
//                .load(url)
//                .circleCrop()
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_foreground)
//                .fallback(R.drawable.ic_launcher_foreground)
//                .into(thumbs)
//        }
//    }
//}






