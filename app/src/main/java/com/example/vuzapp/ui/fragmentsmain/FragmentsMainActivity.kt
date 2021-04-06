package com.example.vuzapp.ui.fragmentsmain

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vuzapp.MainActivity
import com.example.vuzapp.R
import com.example.vuzapp.ui.login.LoginActivity
import com.example.vuzapp.ui.password.PasswordResetActivity
import kotlinx.android.synthetic.main.login_main.*
import kotlinx.android.synthetic.main.main_fragments_layout.*
import kotlinx.android.synthetic.main.registration_main.*

class FragmentsMainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragments_layout)
        setListeners()
    }
    private fun setListeners() {
        profile_fragment.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}