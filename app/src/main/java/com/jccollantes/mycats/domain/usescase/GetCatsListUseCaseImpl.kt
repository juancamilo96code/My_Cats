package com.jccollantes.mycats.domain.usescase

import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource
import com.jccollantes.mycats.data.repositories.CatsRepository

class GetCatsListUseCaseImpl(
    private val catsRepository: CatsRepository
) : GetCatsListUseCase {

    private lateinit var catsResource: Resource<List<Cat?>?>

    override suspend fun invoke(): Resource<List<Cat?>?> {
        catsRepository.getCats().collect {
            catsResource = it
        }
        return catsResource
    }

}