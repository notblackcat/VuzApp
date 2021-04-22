package com.example.vuzapp.ui.fragmentsmain

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vuzapp.Common.Common
import com.example.vuzapp.Common.Common.isSelectedFragment
import com.example.vuzapp.MainActivity
import com.example.vuzapp.R
import com.example.vuzapp.ui.dashboard.DashboardActivityMain
import com.example.vuzapp.ui.home.HomeActivityMain
import com.example.vuzapp.ui.home.HomeFragment
import com.example.vuzapp.ui.library.LibraryActivityMain
import com.example.vuzapp.ui.login.LoginActivity
import com.example.vuzapp.ui.notifications.NotificationActivityMain
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
            isSelectedFragment = "Home"
            startActivity(Intent(this, HomeActivityMain::class.java))
        }
        payment_fragment.setOnClickListener {
            isSelectedFragment = "Dashboard"
            startActivity(Intent(this, DashboardActivityMain::class.java))
        }
        library_fragmnet.setOnClickListener {
            isSelectedFragment = "Library"
            startActivity(Intent(this, LibraryActivityMain::class.java))
        }
        notification_fragmnet.setOnClickListener {
            isSelectedFragment = "Notifications"
            startActivity(Intent(this, NotificationActivityMain::class.java))
        }
    }
}