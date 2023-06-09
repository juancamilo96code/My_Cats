package com.jccollantes.mycats.data.service

import com.jccollantes.mycats.data.model.api.ApiResponse
import com.jccollantes.mycats.data.model.api.GenericErrorApiResponse
import com.jccollantes.mycats.data.model.api.SuccessApiResponse
import com.jccollantes.mycats.utils.API_KEY
import com.jccollantes.mycats.utils.CONTENT_TYPE
import com.jccollantes.mycats.utils.CONTENT_TYPE_VALUE
import com.jccollantes.mycats.utils.TIME_OUT_CONNECT
import com.jccollantes.mycats.utils.TIME_OUT_READ
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiceGenerator(
    private val baseUrl: String,
    private val apiKey: String,
) {

    private lateinit var retrofit: Retrofit
    private val headerMap = mutableMapOf<String, String>()
    private val headerInterceptor = Interceptor { chain ->
        val original = chain.request()
        headerMap[CONTENT_TYPE] = CONTENT_TYPE_VALUE
        headerMap[API_KEY] = apiKey
        val newBuilder = original.url.newBuilder()
        val url = newBuilder.build()
        val headers = getHeaders().addAll(original.headers).build()
        val request = original.newBuilder()
            .url(url)
            .headers(headers)
            .method(original.method, original.body)
            .build()
        chain.proceed(request)

    }

    init {
        setUpRetrofit()
    }

    private fun setUpRetrofit() {
        val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(headerInterceptor)
        okHttpBuilder.connectTimeout(TIME_OUT_CONNECT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(TIME_OUT_READ.toLong(), TimeUnit.SECONDS)
        val client = okHttpBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getHeaders(): Headers.Builder {
        val headers: Headers.Builder = Headers.Builder()
        headerMap.forEach { (key, value) ->
            headers.add(key, value)
        }
        return headers
    }

    fun <S> creaTeService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    suspend fun <Data> processCallWithError(responseCall: suspend () -> Response<Data>): ApiResponse<Data?> {

        val response: Response<Data>?

        return try {
            response = responseCall.invoke()
            if (response.isSuccessful) {
                SuccessApiResponse(response.body())
            } else {
                return GenericErrorApiResponse(response.code(), response.message())
            }
        } catch (ex: Exception) {
            GenericErrorApiResponse(-2, ex.message)
        }
    }

}
