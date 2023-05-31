package com.jccollantes.mycats.domain.usescase

import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource

interface GetCatsListUseCase {

    suspend operator fun invoke(): Resource<List<Cat?>?>
}