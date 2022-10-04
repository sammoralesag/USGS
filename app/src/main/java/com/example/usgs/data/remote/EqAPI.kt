package com.example.usgs.data.remote

import com.example.usgs.data.remote.models.EqResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface EqAPI {

    @GET("all_hour.geojson")
    suspend fun getAllEq(): Response<EqResponseItem>
} 