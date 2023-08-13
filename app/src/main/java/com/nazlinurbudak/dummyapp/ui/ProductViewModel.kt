package com.nazlinurbudak.dummyapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazlinurbudak.dummyapp.data.model.Product
import com.nazlinurbudak.dummyapp.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    var productList = MutableLiveData<List<Product>>()

    init {
        getProducts()
    }

    var a = "Java"

    fun getProducts() {
        viewModelScope.launch {
            val products = productRepository.getProducts()
            Log.d("aasdad", "getProducts: asdad")
            productList.value = products
            println(products)
        }
    }

}