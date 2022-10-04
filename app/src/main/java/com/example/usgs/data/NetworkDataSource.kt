package com.example.usgs.data

import com.example.usgs.data.remote.EqAPI
import com.example.usgs.data.remote.models.EqResponseItem
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: EqAPI
) {
    suspend fun getAllEq(): EqResponseItem? {
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