package com.b57.basictemplate.data.api

import com.b57.architecture.okhttp.ApiResult
import com.b57.architecture.okhttp.mock.AssetsMock
import com.b57.basictemplate.data.entities.Contact
import retrofit2.http.GET

interface TestApi {

    @AssetsMock(dataPath = "getContacts.json", enable = true)
    @GET("/getContacts")
    suspend fun fetchContacts() : ApiResult<Contact>

}