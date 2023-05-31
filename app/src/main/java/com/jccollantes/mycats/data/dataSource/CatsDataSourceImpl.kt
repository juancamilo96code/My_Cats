package com.jccollantes.mycats.data.dataSource

import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource
import com.jccollantes.mycats.data.service.ApiServiceGenerator
import com.jccollantes.mycats.data.service.CatsService
import com.jccollantes.mycats.utils.ResourceBuilder

class CatsDataSourceImpl(
    private val apiServiceGenerator: ApiServiceGenerator
) : CatsDataSource {

    private val catService = apiServiceGenerator.creaTeService(CatsService::class.java)

    override suspend fun getCats(): Resource<List<Cat?>?> {
        val response = apiServiceGenerator.processCallWithError {
            catService.getCats()
        }
        return ResourceBuilder<List<Cat?>?>().build(response)
    }
}