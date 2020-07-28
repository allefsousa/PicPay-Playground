package com.developer.allef.picpay.di.factory

import okhttp3.logging.HttpLoggingInterceptor
import com.developer.allef.picpay.BuildConfig


/**
 * @author allef.santos on 28/07/20
 */
object OkHttpLoggingFactory {
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }


}