package com.b57.architecture.binding

import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["showLoading"])
fun loading(view: ContentLoadingProgressBar, show: Boolean?) {
    if (show == true) {
        view.show()
    } else {
        view.hide()
    }
}
