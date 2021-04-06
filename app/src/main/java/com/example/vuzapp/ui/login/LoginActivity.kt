package com.example.vuzapp.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.vuzapp.MainActivity
import com.example.vuzapp.R
import com.example.vuzapp.ui.fragmentsmain.FragmentsMainActivity
import com.example.vuzapp.ui.password.PasswordResetActivity
import kotlinx.android.synthetic.main.login_main.*


class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)
        setListeners()
    }

    private fun setListeners() {
        loginButton.setOnClickListener {
            startActivity(Intent(this, FragmentsMainActivity::class.java))
            finish()
        }
        forgot_pass.setOnClickListener {
            val mDialog = layoutInflater.inflate(R.layout.password_reset_main,null)
            val mAlertDialog = AlertDialog.Builder(this)
                .setView(mDialog)
                .create()
            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mAlertDialog.show()
        }
    }

}