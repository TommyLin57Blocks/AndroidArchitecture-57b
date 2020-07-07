package com.b57.basictemplate.ui.room.edit

import android.os.Bundle
import android.view.View
import com.b57.basictemplate.R
import com.b57.architecture.base.BindingFragment
import com.b57.basictemplate.databinding.FragmentEntryEditBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Edit room content
 */
class EntryEditFragment : BindingFragment<FragmentEntryEditBinding>() {

    private val viewModel : EntryEditViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.fragment_entry_edit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDb.vm = viewModel
    }


}