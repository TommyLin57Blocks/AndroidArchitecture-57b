package com.b57.architecture.paging

/**
 * Paging status
 */
open class PagingSourceStatus() {
    /**
     * Load init Status
     */
    data class LoadInit(val status: LoadStatus) : PagingSourceStatus()

    /**
     * Load after status
     */
    data class LoadAfter(val status: LoadStatus) : PagingSourceStatus()

    /**
     * Load before status
     */
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