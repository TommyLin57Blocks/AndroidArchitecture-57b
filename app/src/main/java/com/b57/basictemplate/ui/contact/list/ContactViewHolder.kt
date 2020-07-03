package com.b57.basictemplate.ui.contact.list

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.b57.basictemplate.R
import com.b57.basictemplate.data.entities.Contact
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_contact.*

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {


    init {
        itemView.setOnClickListener {
            it.findNavController().navigate(Uri.parse("b57://app/contact/detail"))
        }

    }
    fun bind(contact: Contact?) {
        itemContactLoadPb.visibility = if (contact == null) View.VISIBLE else View.GONE
        itemContactNameTv.visibility = if (contact == null) View.GONE else View.VISIBLE
        itemContactPhoneTv.visibility = if (contact == null) View.GONE else View.VISIBLE
        itemContactNameTv.text = contact?.name ?: ""
        itemContactPhoneTv.text = contact?.phone ?: ""
    }

    companion object {

        fun inflate(parent: ViewGroup): ContactViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
            return ContactViewHolder(view)
        }

    }

    override val containerView: View?
        get() = itemView
}