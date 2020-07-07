package com.b57.architecture.okhttp.mock

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.http.GET
import retrofit2.http.POST
import timber.log.Timber
import java.lang.reflect.Method

class MockInterceptor(mockClass: Class<*>, private val iDataMocker: IDataMocker) :
    Interceptor {

    init {
        iDataMocker.setupMockApi(mockClass)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val responseContent = iDataMocker.mock(request = chain.request())
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





