package com.mostafa.foodapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodapp.data.netWorking.Details.ApietailsHelper
import com.mostafa.foodapp.data.reoisitory.DetailsRepository

class DetailsViewModelFactory(private val apietailsHelper: ApietailsHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {

            return DetailsViewModel(DetailsRepository(apietailsHelper)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}