package com.b57.architecture.paging

open class PagingSourceStatus() {
    data class LoadInit(val status: LoadStatus) : PagingSourceStatus()
    data class LoadAfter(val status: LoadStatus) : PagingSourceStatus()
    data class LoadBefore(val status: LoadStatus) : PagingSourceStatus()
}

open class LoadStatus {
    object Succeed : LoadStatus()
    object Loading : LoadStatus()
    data class Failed(val e: Throwable) : LoadStatus()

    override fun toString(): String {
        return when (this) {
            Loading -> "Loading"
            Succeed -> "Success"
            is Failed -> "Error[exception=$e]"
            else -> ""
        }
    }
}