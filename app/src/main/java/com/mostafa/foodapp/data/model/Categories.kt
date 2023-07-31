package com.mostafa.foodapp.data.model
import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.annotations.SerializedName
data class Categories(
  @SerializedName("idCategory")
  val idCategory: String,
  @SerializedName("strCategory")
  val strCategory: String?,
  @SerializedName("strCategoryDescription")
  val strCategoryDescription: String,
  @SerializedName("strCategoryThumb")
  val strCategoryThumb:  String?
//    @Json(name = "img_src") val imgSrcUrl: String
){
 object CategoryData {
     @SuppressLint("SuspiciousIndentation")
     fun getCategoryData(context:Context):ArrayList<Categories>{
     val  categories= ArrayList<Categories>()
         return categories
  }
 }
}


