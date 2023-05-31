package com.jccollantes.mycats.data.repositories

import com.jccollantes.mycats.data.dataSource.CatsDataSource
import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatsRepositoryImpl(
    private val catsDataSource: CatsDataSource
) : CatsRepository {
    override suspend fun getCats(): Flow<Resource<List<Cat?>?>> {
        return flow<Resource<List<Cat?>?>> {
            val response = catsDataSource.getCats()
            if (response is Resource.Success) {
                emit(Resource.Success(response.data))
            } else {
                emit(Resource.GenericDataError(response.errorCode, response.errorMessage))
            }
        }
    }
}