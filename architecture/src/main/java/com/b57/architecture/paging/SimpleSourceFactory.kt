package com.b57.architecture.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

/**
 * We need call 'invalidate' of DataSource to refresh list,
 * So add a live data of DataSource, Which hold the latest data source instance
 */
abstract class SimpleSourceFactory<S : DataSource<K, V> , K, V> : DataSource.Factory<K, V>() {

    val sourceLiveData = MutableLiveData<S>()

    override fun create(): DataSource<K, V> {
        val source = createDataSource()
        sourceLiveData.postValue(source)
        return source
    }

    /**
     * always return a new instance
     */
    abstract fun createDataSource() : S
}