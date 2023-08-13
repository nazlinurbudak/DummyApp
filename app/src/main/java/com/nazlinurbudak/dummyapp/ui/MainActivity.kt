package com.nazlinurbudak.dummyapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nazlinurbudak.dummyapp.data.api.ProductApiService
import com.nazlinurbudak.dummyapp.data.repository.ProductRepository
import com.nazlinurbudak.dummyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductViewModel
    private lateinit var apiService: ProductApiService
    private val adapter by lazy { ProductAdapter(emptyList()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val productRepository = ProductRepository()
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(productRepository)
        )[ProductViewModel::class.java]

        //Toast.makeText("")


        binding.productListRecyclerView.layoutManager = LinearLayoutManager(this)


        binding.productListRecyclerView.adapter = adapter

        viewModel.productList.observe(this) {
            adapter.updateData(it)
        }


    }
}