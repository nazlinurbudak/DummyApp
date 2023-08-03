package com.nazlinurbudak.dummyapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazlinurbudak.dummyapp.data.model.Product
import com.nazlinurbudak.dummyapp.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    var productList = MutableLiveData<List<Product>>()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            val products = productRepository.getProducts()
            productList.value = products
        }
    }

}