package com.b57.architecture.okhttp

import com.b57.architecture.BuildConfig
import com.b57.architecture.okhttp.mock.AssetsDataMocker
import com.b57.architecture.okhttp.mock.IDataMocker
import com.b57.architecture.okhttp.mock.MockInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object ApiClientFactory {

    /**
     * build a retrofit
     */
    fun <T> build(
        baseUrl: String,
        clazz: Class<T>,
        iDataMocker: IDataMocker = AssetsDataMocker()
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient(clazz, iDataMocker))
            .build()
            .create(clazz)
    }

    /**
     * create a okHttpClient
     * if mock api is enabled, add dataMocker for okHttpClient
     */
    private fun <T> createOkHttpClient(clazz: Class<T>, iDataMocker: IDataMocker): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor(
                    object : HttpLoggingInterceptor.Logger {
                        override fun log(message: String) {
                            Timber.tag("b57-http").d(message)
                        }
                    }
                ).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        if (BuildConfig.ENABLE_MOCK_API) {
            iDataMocker.setupMockApi(clazz)
            builder.addInterceptor(MockInterceptor(iDataMocker))
        }
        return builder.build()
    }


}