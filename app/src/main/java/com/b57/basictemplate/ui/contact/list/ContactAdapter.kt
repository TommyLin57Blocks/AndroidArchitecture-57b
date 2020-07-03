package com.b57.basictemplate.ui.contact.list

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.b57.basictemplate.data.entities.Contact

class ContactAdapter : PagedListAdapter<Contact, ContactViewHolder>(differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem.phone == newItem.phone

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem == newItem
        }
    }
}