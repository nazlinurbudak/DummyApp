package com.nazlinurbudak.dummyapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nazlinurbudak.dummyapp.data.model.Product
import com.nazlinurbudak.dummyapp.databinding.ProductItemBinding

class ProductAdapter(
    private var products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindProduct(product: Product) = with(binding) {
            productTextView.text = product.title
            Glide.with(itemView).load(product.thumbnail).into(productImageView)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding =
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ProductViewHolder(binding)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(product: List<Product>) {
        this.products = product
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(products.get(position))
    }

}