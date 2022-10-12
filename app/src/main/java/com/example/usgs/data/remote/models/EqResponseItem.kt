package com.example.usgs.data.remote.models


import com.google.gson.annotations.SerializedName

data class EqResponseItem(
    @SerializedName("features")
    val features: List<Feature>?,

)