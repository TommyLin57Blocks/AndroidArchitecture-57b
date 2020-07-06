package com.b57.basictemplate.ui.recycler_bind

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.b57.architecture.adapter.BaseDataBindingAdapter
import com.b57.basictemplate.R
import com.b57.basictemplate.data.entities.Contact
import com.b57.basictemplate.databinding.ItemRecyclerBindContentBinding

class ContactAdapter : BaseDataBindingAdapter<Contact, ItemRecyclerBindContentBinding>(differ) {

    override fun getLayoutResId(viewType: Int): Int = R.layout.item_recycler_bind_content

    override fun onBindContent(
        binding: ItemRecyclerBindContentBinding?,
        item: Contact?,
        holder: RecyclerView.ViewHolder?
    ) {
        binding?.contact = item
    }

    override fun onBindListener(
        binding: ItemRecyclerBindContentBinding?,
        item: Contact?,
        holder: RecyclerView.ViewHolder?
    ) {
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem.phone == newItem.phone

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem == newItem
        }
    }
}