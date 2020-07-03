package com.b57.architecture.binding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.b57.architecture.paging.LoadStatus
import com.b57.architecture.paging.PagingSourceStatus
import timber.log.Timber

@BindingAdapter(value = ["pagingStatus"])
fun bindLoadingStatus(view : SwipeRefreshLayout, status : PagingSourceStatus?) {
    if (status is PagingSourceStatus.LoadInit) {
        view.isRefreshing = status.status == LoadStatus.Loading
    }
}

@BindingAdapter(value = ["onRefresh"])
fun bindRefresh(view: SwipeRefreshLayout, listener : SwipeRefreshLayout.OnRefreshListener) {
    view.setOnRefreshListener(listener)
}