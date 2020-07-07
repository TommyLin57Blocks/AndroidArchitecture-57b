package com.b57.basictemplate.ui.okhttp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.b57.basictemplate.domain.okhttp.FetchContactByNetwork

class HttpDemoViewModel(
    private val fetchContactByNetwork: FetchContactByNetwork
) : ViewModel() {

    val contact = liveData {
        emit(fetchContactByNetwork())
    }

}