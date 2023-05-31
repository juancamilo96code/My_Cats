package com.jccollantes.mycats.data.repositories

import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    suspend fun getCats(): Flow<Resource<List<Cat?>?>>
}