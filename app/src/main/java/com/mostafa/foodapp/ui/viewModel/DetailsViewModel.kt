package com.mostafa.foodapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodapp.data.model.Details
import com.mostafa.foodapp.data.reoisitory.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val detailsRepository: DetailsRepository): ViewModel() {
    val detail= MutableLiveData<Details>()

    init {
        getDetails()
    }fun getDetails() {
        viewModelScope.launch (Dispatchers.IO){
            val response=detailsRepository.getdetail()
            if (response.isSuccessful){
                detail.postValue(response.body())
                Log.d("out",response.body().toString())
            }
        }
    }
}