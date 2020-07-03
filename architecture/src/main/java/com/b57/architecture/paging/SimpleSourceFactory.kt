package com.b57.architecture.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

abstract class SimpleSourceFactory<S : DataSource<K, V> , K, V> : DataSource.Factory<K, V>() {

    val sourceLiveData = MutableLiveData<S>()

    override fun create(): DataSource<K, V> {
        val source = createDataSource()
        sourceLiveData.postValue(source)
        return source
    }

    abstract fun createDataSource() : S
}