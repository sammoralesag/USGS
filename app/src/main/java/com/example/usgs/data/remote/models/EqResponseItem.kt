package com.example.usgs.data.remote.models


import com.google.gson.annotations.SerializedName

data class EqResponseItem(
    @SerializedName("bbox")
    val bbox: List<Double?>?,
    @SerializedName("features")
    val features: List<Feature>?,
    @SerializedName("metadata")
    val metadata: Metadata?,
    @SerializedName("type")
    val type: String?
)