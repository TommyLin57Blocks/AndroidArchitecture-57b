package com.b57.architecture.log

import android.annotation.SuppressLint
import android.util.Log
import timber.log.Timber

class ErrorDebugTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority != Log.ERROR && priority != Log.WARN) {
            return
        }
        Log.e(TAG, "tag = $tag, message = $message, priority = $priority, e = ${t?.message}")
    }

    companion object {
        private const val TAG = "ErrorTree"
    }

}