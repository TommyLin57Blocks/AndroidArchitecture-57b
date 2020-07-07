package com.b57.basictemplate.domain.okhttp

import com.b57.basictemplate.data.api.TestApi
import com.b57.basictemplate.data.entities.Contact

class FetchContactByNetwork(
    private val testApi: TestApi
) {

    suspend operator fun invoke() : Contact {
        return testApi.fetchContacts().data
    }
}