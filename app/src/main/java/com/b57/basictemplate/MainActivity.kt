package com.b57.basictemplate

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b57.basictemplate.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        contactBtn.setOnClickListener {
            val intent = Intent().apply {
                data = Uri.parse("b57://app/contact")
            }
            startActivity(intent)
        }

        roomBtn.setOnClickListener {
            val intent = Intent().apply {
                data = Uri.parse("b57://app/room/sample")
            }
            startActivity(intent)
        }

        recyclerBtn.setOnClickListener {
            val intent = Intent().apply {
                data = Uri.parse("b57://app/recycler")
            }
            startActivity(intent)
        }

        okhttpBtn.setOnClickListener {
            val intent = Intent().apply {
                data = Uri.parse("b57://app/httpdemo")
            }
            startActivity(intent)
        }

    }
}
