package com.b57.architecture.okhttp.mock

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val iDataMocker: IDataMocker) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val responseContent = iDataMocker.mock(request = chain.request())

        // If no mock data, request by next interceptor
        if (responseContent.isEmpty()) {
            return chain.proceed(chain.request())
        }
        return Response.Builder()
            .request(chain.request())
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message("This is a mock response")
            .addHeader("content-type", "application/json")
            .body(responseContent.toResponseBody("application/json".toMediaTypeOrNull()))
            .build()
    }

}





