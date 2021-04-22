package com.example.vuzapp.Remote

import com.example.vuzapp.model.APIResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMyAPI {

    @FormUrlEncoded
    @POST("test.php")
    fun loginUser(@Field("phone_number") phone_number:String,@Field("password") password:String): Call<APIResponse>

}