package com.b57.architecture.binding;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {"adapter"})
    public static void bindAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter(value = {"submitList"})
    public static void bindData(RecyclerView recyclerView, List list) {
        if (recyclerView.getAdapter() == null) {
            return;
        }
        if (recyclerView.getAdapter() instanceof PagedListAdapter && list instanceof PagedList) {
            ((PagedListAdapter) recyclerView.getAdapter()).submitList((PagedList) list);
        }
        if (recyclerView.getAdapter() instanceof ListAdapter) {
            ((ListAdapter) recyclerView.getAdapter()).submitList(list);
        }
    }

}
