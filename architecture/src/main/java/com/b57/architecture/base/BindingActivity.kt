package com.b57.architecture.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<BD : ViewDataBinding> : BaseActivity() {

    protected lateinit var viewDb : BD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDb = DataBindingUtil.setContentView<BD>(this, layoutId)
        viewDb.lifecycleOwner = this
    }
}