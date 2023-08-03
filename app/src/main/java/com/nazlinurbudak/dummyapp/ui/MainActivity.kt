package com.nazlinurbudak.dummyapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nazlinurbudak.dummyapp.R
import com.nazlinurbudak.dummyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ProductViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.productList.observe(this) { products ->
            binding.productListRecyclerView.adapter = ProductAdapter(products)
        }


    }
}