package com.b57.basictemplate.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.b57.basictemplate.R
import com.b57.architecture.base.BindingActivity
import com.b57.basictemplate.databinding.ActivityLoginBinding
import com.b57.architecture.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BindingActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDb.vm = viewModel
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.toastEvent.observe(this, EventObserver {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.loginResult.observe(this, Observer {
            finish()
        })
    }

}