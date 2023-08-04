package com.mostafa.foodapp.data.model
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName


data class Categories(
  @SerializedName("categories")
  val  categories:ArrayList<Category>){
  data class Category(
    val idCategory: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb:  String
    )


}
//data class Categories(
//  @SerializedName("idCategory")
//  val idCategory: String,
//    @SerializedName("strCategory")
//  val strCategory: String?,
//    @SerializedName("strCategoryDescription")
//  val strCategoryDescription: String,
//    @SerializedName("strCategoryThumb")
//  val strCategoryThumb: Drawable?
////    @Json(name = "img_src") val imgSrcUrl: String)(
//
//)
//
//

