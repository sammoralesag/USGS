package com.example.usgs.domain

import com.example.usgs.domain.models.Eq

interface EqRepository {
    suspend fun getEqList(): List<Eq>
}