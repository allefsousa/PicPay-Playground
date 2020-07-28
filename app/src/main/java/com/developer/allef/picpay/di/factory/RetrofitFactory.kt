package com.developer.allef.picpay.di.factory

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author allef.santos on 28/07/20
 */
object RetrofitFactory {
    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
            .create(T::class.java)
    }
}