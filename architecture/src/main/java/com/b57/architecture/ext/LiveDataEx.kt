package com.b57.architecture.ext

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

inline fun <X, Y> LiveData<X>.mapWithDefaultValue(
    defaultValue: Y,
    crossinline transform: (X) -> Y
): LiveData<Y> =
    mapLiveData(defaultValue, this) {
        transform(it)
    }

@MainThread
fun <X, Y> mapLiveData(
    defaultValue: Y,
    source: LiveData<X>,
    mapFunction: (X) -> Y
): LiveData<Y> {
    val result = MediatorLiveData<Y>().apply {
        value = defaultValue
    }
    result.addSource(
        source
    ) { x -> result.value = mapFunction(x) }
    return result
}