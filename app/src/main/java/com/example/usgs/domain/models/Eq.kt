package com.example.usgs.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Eq(
    val place: String,
    val mg: Double,
    val time: Long,
    val long: Double,
    val lat: Double,
    val id: String

) : Parcelable
