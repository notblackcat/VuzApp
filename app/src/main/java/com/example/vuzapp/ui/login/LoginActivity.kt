package com.example.vuzapp.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.vuzapp.Common.Common
import com.example.vuzapp.MainActivity
import com.example.vuzapp.R
import com.example.vuzapp.Remote.IMyAPI
import com.example.vuzapp.model.APIResponse
import com.example.vuzapp.ui.fragmentsmain.FragmentsMainActivity
import com.example.vuzapp.ui.notifications.bottomsheet.PaymentNotificationBottomSheet
import com.example.vuzapp.ui.password.PasswordResetActivity
import kotlinx.android.synthetic.main.login_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity: AppCompatActivity() {

    var isAuthenticated:Int?=null
    internal lateinit var mService: IMyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)
        mService = Common.getApi(this)
        setListeners()
    }

    private fun setListeners() {
        loginButton.setOnClickListener {
            authenticateUser(phone_number_ti.text.toString(),PasswordInput_ti.text.toString())
        }
        forgot_pass.setOnClickListener {
            val mDialog = layoutInflater.inflate(R.layout.password_reset_main,null)
            val mAlertDialog = AlertDialog.Builder(this)
                .setView(mDialog)
                .create()
            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mAlertDialog.show()
        }
        check_saveme.setOnClickListener {
            val dialog = PaymentNotificationBottomSheet.newInstance()
            dialog.show(supportFragmentManager, PaymentNotificationBottomSheet.TAG)
        }
    }

    private fun authenticateUser(phone_number: String, password: String) {
        mService.loginUser(phone_number, password)
            .enqueue(object : Callback<APIResponse> {

                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t!!.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if (response!!.body()!!.success == 0) {
                        Toast.makeText(
                            this@LoginActivity, "Login or password is incorrect",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else {
                        isAuthenticated = 1
                        Common.phone_number = response!!.body()!!.message?.login
                        Common.full_name = response!!.body()!!.message?.full_name.toString()
                        var first_space = Common.full_name?.indexOf(" ", 0, false)
                        var second_space = Common.full_name?.indexOf(" ", first_space!! + 1, false)
                        Common.surname = Common.full_name?.substring(0, first_space!!)
                        Common.v_name = Common.full_name?.substring(first_space!!, second_space!!)
                        Toast.makeText(this@LoginActivity, "Login Success" + isAuthenticated.toString(), Toast.LENGTH_SHORT)
                            .show()
                        go_to_next()
                    }
                }
            })

    }

    private fun go_to_next(){
        startActivity(Intent(this, FragmentsMainActivity::class.java))
    }

}