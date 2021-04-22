package com.example.vuzapp.Common

import android.content.Context
import com.example.vuzapp.Remote.IMyAPI
import com.example.vuzapp.Remote.RetrofitClient

object Common {
    val BASE_URL = "https://bx.svo.kz/aslan/"
    var phone_number:String? = null
    var full_name:String? = null
    var surname:String? = null
    var v_name:String? = null
    var isSelectedFragment:String? = null

    fun getApi(context: Context): IMyAPI =
        RetrofitClient.getClient(BASE_URL, context).create(IMyAPI::class.java)
}