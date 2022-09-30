package com.example.usgs.data.mapper

import com.example.usgs.data.remote.models.EqResponse
import com.example.usgs.domain.models.Eq

fun EqResponse.toDomain(): Eq = Eq(

    place = this.features[2].properties.place?:"",
    mg = this.features[2].properties.mag,
    time = this.features[2].properties.time,
    long = this.features[0].geometry.coordinates[0],
    lat = this.features[0].geometry.coordinates[1],
    id = this.features[1].id

)