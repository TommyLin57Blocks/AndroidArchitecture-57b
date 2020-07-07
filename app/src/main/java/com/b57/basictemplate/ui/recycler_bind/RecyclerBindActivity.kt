package com.b57.basictemplate.ui.recycler_bind

import android.os.Bundle
import android.view.View
import com.b57.architecture.base.BindingActivity
import com.b57.basictemplate.R
import com.b57.basictemplate.databinding.FragmentRecyclerBindBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Binding recyclerView Demo Page
 */
class RecyclerBindActivity: BindingActivity<FragmentRecyclerBindBinding>() {

    private val viewModel : RecyclerViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.fragment_recycler_bind

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDb.adapter = ContactAdapter()
        viewDb.vm = viewModel
    }

}