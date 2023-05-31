package com.jccollantes.mycats.data.dataSource

import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource

interface CatsDataSource {
    suspend fun getCats(): Resource<List<Cat?>?>
}