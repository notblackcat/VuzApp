package com.example.vuzapp.Remote

import android.content.Context
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient{
    private var retrofit:Retrofit?=null
    fun getClient(baseUrl: String, context: Context):Retrofit{
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))
                .build()
            val gson = GsonBuilder().setLenient().create()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit!!
    }
}