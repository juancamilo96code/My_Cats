package com.jccollantes.mycats.data.service

import com.jccollantes.mycats.data.model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatsService {

    @GET("breeds")
    suspend fun getCats(): Response<List<Cat?>?>
}