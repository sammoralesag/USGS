package com.example.usgs.data.mapper

import com.example.usgs.data.remote.models.Feature
import com.example.usgs.domain.models.Eq

fun Feature.toDomain(): Eq = Eq(

    place = this.properties?.place ?: "",
    mg = this.properties?.mag ?: 0.0,
    time = this.properties?.time ?: 0L,
    long = this.geometry?.coordinates?.get(0) ?: 0.0,
    lat = this.geometry?.coordinates?.get(1) ?: 0.0,
    id = this.id ?: ""

)