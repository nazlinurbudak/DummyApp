package com.nazlinurbudak.dummyapp.data.api

import com.nazlinurbudak.dummyapp.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiInterface {
    @GET("products")
    suspend fun getProducts():Response<ProductResponse>
}