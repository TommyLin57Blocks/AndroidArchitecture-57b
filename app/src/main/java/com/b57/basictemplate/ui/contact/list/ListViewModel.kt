package com.b57.basictemplate.ui.contact.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.b57.architecture.paging.SimpleSourceFactory
import com.b57.basictemplate.data.entities.Contact

class ListViewModel : ViewModel() {

    private val sourceFactory = object : SimpleSourceFactory<ContactPagingSource, Int, Contact>() {
        override fun createDataSource(): ContactPagingSource = ContactPagingSource()
    }

    val loadStatusLiveData = sourceFactory.sourceLiveData.map {
        it.statusLiveData
    }

    val contactLiveData = sourceFactory.toLiveData(
        config = PagedList.Config.Builder().setPageSize(30).build()
    )

    fun onRefresh() {
        sourceFactory.sourceLiveData.value?.invalidate()
    }

}