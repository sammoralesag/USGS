package com.example.usgs.data.remote.models


import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("mag")
    val mag: Double,
    @SerializedName("place")
    val place: String?,
    @SerializedName("time")
    val time: Long,
)