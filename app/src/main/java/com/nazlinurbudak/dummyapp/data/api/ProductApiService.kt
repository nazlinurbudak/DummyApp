package com.nazlinurbudak.dummyapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductApiService {


    private val BASE_URL = "https://dummyjson.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    val api: ProductApiInterface by lazy {
        retrofit.create(ProductApiInterface::class.java)
    }

}