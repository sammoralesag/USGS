package com.example.usgs.data.remote

import com.example.usgs.data.NetworkDataSource
import com.example.usgs.data.mapper.toDomain
import com.example.usgs.domain.EqRepository
import com.example.usgs.domain.models.Eq
import javax.inject.Inject

class EqRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
) : EqRepository {
    override suspend fun getEqList(): List<Eq> {
        val response = dataSource.getAllEq()
        val featureList = response?.features
        return featureList?.map { it.toDomain() }?: emptyList()
    }


}


