package com.b57.architecture.binding

import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import timber.log.Timber

@BindingAdapter(value = ["showLoading"])
fun loading(view: ContentLoadingProgressBar, show: Boolean) {
    Timber.tag("testBind").d("show = $show")
    if (show) {
        view.show()
    } else {
        view.hide()
    }
}
