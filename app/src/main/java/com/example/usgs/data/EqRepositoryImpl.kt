package com.example.usgs.data

import com.example.usgs.data.mapper.toDomain
import com.example.usgs.data.remote.NetworkDataSource
import com.example.usgs.domain.EqRepository
import com.example.usgs.domain.models.Eq
import javax.inject.Inject

class EqRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
) : EqRepository {
    override suspend fun getEqList(): List<Eq> {
        val response = dataSource.getAllEq()
        return response?.map { it.toDomain() }?: emptyList()
    }


}


//millisec to format date
//list?, mapper?,
//parse data, Gson obj