package com.example.usgs.data.remote

import com.example.usgs.data.remote.models.EqResponse
import retrofit2.Response
import retrofit2.http.GET

interface EqAPI {

    @GET("all_hour.geojson")
    suspend fun getAllEq(): Response<List<EqResponse>>
} 