package com.nazlinurbudak.dummyapp.data.repository

import com.nazlinurbudak.dummyapp.data.api.ProductApiService
import com.nazlinurbudak.dummyapp.data.model.Product

class ProductRepository() {
    private val productApiService: ProductApiService = ProductApiService()

     fun getProducts(): List<Product> {
        return try {
            val response = productApiService.api.getProducts()
            if (response.isSuccessful) {
                val productResponse = response.body()
                productResponse?.products ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}

