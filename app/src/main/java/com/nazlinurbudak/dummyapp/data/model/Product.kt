package com.nazlinurbudak.dummyapp.data.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)