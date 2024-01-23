package com.example.openinapp.api

import com.example.openinapp.OpenInModel.Data
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @POST("v1/dashboardNew")
    suspend fun getLink(): Response<Data>


}