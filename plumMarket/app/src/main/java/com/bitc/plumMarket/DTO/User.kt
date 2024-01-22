package com.bitc.plumMarket.DTO

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("pw")
    val pw: String
)
