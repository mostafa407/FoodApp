package com.mostafa.foodapp.data.netWorking.Details

class ApietailsHelper(private val apiIDetails: ApiIDetails) {
        suspend fun getdetail()=apiIDetails.getdetail(52874)
}