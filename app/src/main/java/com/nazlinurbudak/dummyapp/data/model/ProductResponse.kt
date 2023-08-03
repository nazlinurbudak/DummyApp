package com.nazlinurbudak.dummyapp.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("results")
    val products: List<Product>
)