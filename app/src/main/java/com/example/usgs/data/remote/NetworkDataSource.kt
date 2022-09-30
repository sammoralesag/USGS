package com.example.usgs.data.remote

import com.example.usgs.data.remote.models.EqResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: EqAPI
) {
    suspend fun getAllEq(): List<EqResponse>? {
        return try {
            val response = api.getAllEq()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}