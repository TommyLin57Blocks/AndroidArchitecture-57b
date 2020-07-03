package com.b57.basictemplate.ui.contact.list

import android.os.Bundle
import android.view.View
import com.b57.basictemplate.R
import com.b57.architecture.base.BindingFragment
import com.b57.basictemplate.databinding.FragmentContactListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 联系人列表页面，使用Paging分页
 */
class ListFragment : BindingFragment<FragmentContactListBinding>() {

    private val viewModel : ListViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.fragment_contact_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDb.adapter = ContactAdapter()
        viewDb.vm = viewModel
    }
}