package com.b57.basictemplate.ui.okhttp

import android.os.Bundle
import com.b57.architecture.base.BindingActivity
import com.b57.basictemplate.R
import com.b57.basictemplate.databinding.ActivityHttpDemoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HttpDemoActivity : BindingActivity<ActivityHttpDemoBinding>() {

    private val viewModel: HttpDemoViewModel by viewModel()


    override val layoutId: Int
        get() = R.layout.activity_http_demo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDb.vm = viewModel
    }
}