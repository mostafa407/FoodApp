package com.mostafa.foodapp.data.reoisitory

import com.mostafa.foodapp.data.netWorking.Details.ApietailsHelper

class DetailsRepository( val apietailsHelper: ApietailsHelper) {
    suspend fun getdetail()=apietailsHelper.getdetail()
}