package com.nazlinurbudak.dummyapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductApiService {


    private val BASE_URL = "https://dummyjson.com/"

    private fun retrofit() : Retrofit {

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
       return Retrofit.Builder()
            .baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

     fun api() : ProductApiInterface {
       return retrofit().create(ProductApiInterface::class.java)
    }

}