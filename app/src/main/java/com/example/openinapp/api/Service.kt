package com.example.openinapp.api

import com.example.openinapp.OpenInModel.Data
import com.example.openinapp.OpenInModel.TopLinks
import com.example.openinapp.constants.AppConstants
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET("v1/dashboardNew")
    @Headers("Authorization: Bearer ${AppConstants.header}")
    suspend fun getLink(): Response<TopLinks>

}