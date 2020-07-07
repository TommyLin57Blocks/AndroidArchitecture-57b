package com.b57.basictemplate.ui.okhttp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.b57.basictemplate.data.entities.Contact
import com.b57.basictemplate.domain.FetchContactByNetwork
import kotlinx.coroutines.launch

class HttpDemoViewModel(
    private val fetchContactByNetwork: FetchContactByNetwork
) : ViewModel() {

    val contact = liveData {
        emit(fetchContactByNetwork())
    }

}