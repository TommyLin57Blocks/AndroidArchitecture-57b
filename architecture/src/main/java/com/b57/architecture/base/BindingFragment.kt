package com.b57.architecture.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingFragment<BD : ViewDataBinding> : BaseFragment() {

    protected lateinit var viewDb : BD

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDb = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewDb.lifecycleOwner = this
        return viewDb.root
    }

}