package com.b57.architecture.okhttp.mock

import okhttp3.Request

interface IDataMocker {

    fun setupMockApi(mockClass: Class<*>)

    fun mock(request: Request): String

}