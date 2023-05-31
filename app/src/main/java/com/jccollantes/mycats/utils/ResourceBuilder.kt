package com.jccollantes.mycats.utils

import com.jccollantes.mycats.data.model.Resource
import com.jccollantes.mycats.data.model.api.ApiResponse
import com.jccollantes.mycats.data.model.api.GenericErrorApiResponse
import com.jccollantes.mycats.data.model.api.SuccessApiResponse

class ResourceBuilder<T> {
    fun build(response: ApiResponse<T?>): Resource<T?> {
        return when (response) {
            is SuccessApiResponse<*> -> {
                val body = response.body as T
                Resource.Success(body)
            }

            else -> {
                Resource.GenericDataError(
                    (response as GenericErrorApiResponse).code,
                    response.message
                )
            }
        }
    }
}