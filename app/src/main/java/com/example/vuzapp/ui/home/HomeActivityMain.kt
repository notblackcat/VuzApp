package com.example.vuzapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.vuzapp.Common.Common.isSelectedFragment
import com.example.vuzapp.R
import kotlinx.android.synthetic.main.activity_main.*
    class HomeActivityMain : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val navController = findNavController(R.id.nav_host_fragment)
            val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home))
            nav_view.setupWithNavController(navController)
        }
    }
