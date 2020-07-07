package com.b57.basictemplate.ui.contact.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.b57.architecture.paging.LoadStatus
import com.b57.architecture.paging.PagingSourceStatus
import com.b57.basictemplate.data.entities.Contact
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


/**
 * paging source for contact list
 */
class ContactPagingSource :
    PageKeyedDataSource<Int, Contact>() {

    val statusLiveData = MutableLiveData<PagingSourceStatus>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Contact>
    ) {
        Timber.d("loadInitial, params.requestedLoadSize = ${params.requestedLoadSize}, placeholdersEnabled = ${params.placeholdersEnabled}")
        GlobalScope.launch {
            statusLiveData.postValue(
                PagingSourceStatus.LoadInit(
                    LoadStatus.Loading
                )
            )
            delay(3 * 1000)
            statusLiveData.postValue(
                PagingSourceStatus.LoadInit(
                    LoadStatus.Succeed
                )
            )
            callback.onResult((1..30).toList().map {
                Contact(
                    "Page 1 Name - $it",
                    "Page 1 Phone - $it"
                )
            }, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Contact>) {
        Timber.d("loadAfter, key = ${params.key}, requestedLoadSize = ${params.requestedLoadSize}")
        GlobalScope.launch {
            statusLiveData.postValue(
                PagingSourceStatus.LoadAfter(
                    LoadStatus.Loading
                )
            )
            delay(3 * 1000)
            val data = (1..30).toList().map {
                Contact(
                    "Page ${params.key} Name - $it",
                    "Page ${params.key} Phone - $it"
                )
            }
            statusLiveData.postValue(
                PagingSourceStatus.LoadAfter(
                    LoadStatus.Succeed
                )
            )
            callback.onResult(data, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Contact>) {
        Timber.d("loadBefore, key = ${params.key}, requestedLoadSize = ${params.requestedLoadSize}")
        GlobalScope.launch {
            statusLiveData.postValue(
                PagingSourceStatus.LoadBefore(
                    LoadStatus.Loading
                )
            )
            delay(3 * 1000)
            val data = (1..30).toList().map {
                Contact(
                    "Page ${params.key} Name - $it",
                    "Page ${params.key} Phone - $it"
                )
            }
            statusLiveData.postValue(
                PagingSourceStatus.LoadBefore(
                    LoadStatus.Succeed
                )
            )
            callback.onResult(data, params.key - 1)
        }

    }

}