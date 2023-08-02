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

class CategoryRecyclerView() :
    RecyclerView.Adapter<CategoryRecyclerView.CategoryViewHolder>() {
    private lateinit var binding: ListItemBinding
    private lateinit var  categoiesList:List<Categories.Category>
    lateinit var categories: ArrayList<Categories>
    fun setCategoryList(categories: ArrayList<Categories>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    class CategoryViewHolder(private var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categories: Categories.Category) {
            binding.model = categories
        }
    }

    var category = mutableListOf<Categories>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categories = categoiesList[position]
        holder.bind(categories)

    }

    override fun getItemCount(): Int {
        return categoiesList.size
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thumbs: ImageView, url: String) {
            Glide.with(thumbs)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbs)
        }
    }
}






