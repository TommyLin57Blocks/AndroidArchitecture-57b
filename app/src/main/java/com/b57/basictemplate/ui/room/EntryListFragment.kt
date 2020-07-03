package com.b57.basictemplate.ui.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.b57.basictemplate.R
import com.b57.architecture.base.BindingFragment
import com.b57.basictemplate.data.entities.RoomEntry
import com.b57.basictemplate.databinding.FragmentEntryListBinding
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_room_entry.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntryListFragment : BindingFragment<FragmentEntryListBinding>() {

    private val viewModel: EntryListViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.fragment_entry_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDb.adapter = EntryAdapter()
        viewDb.vm = viewModel
    }
}

class EntryViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bind(roomEntry: RoomEntry) {
        roomEntryTv.text = roomEntry.content
    }

    companion object {
        fun inflate(parent: ViewGroup): EntryViewHolder {
            return EntryViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_room_entry, parent, false)
            )
        }
    }


}


class EntryAdapter : ListAdapter<RoomEntry, EntryViewHolder>(differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<RoomEntry>() {
            override fun areItemsTheSame(oldItem: RoomEntry, newItem: RoomEntry): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RoomEntry, newItem: RoomEntry): Boolean {
                return oldItem.content == newItem.content
            }

        }
    }

}