package com.developer.allef.picpay.di

import com.developer.allef.picpay.BuildConfig
import com.developer.allef.picpay.di.factory.OkHttpFactory
import com.developer.allef.picpay.di.factory.OkHttpLoggingFactory
import com.developer.allef.picpay.di.factory.RetrofitFactory
import com.developer.allef.picpay.service.ApiService
import org.koin.dsl.module

/**
 * @author allef.santos on 28/07/20
 */

val appModule = module {
}


val networkModule = module {
    single { OkHttpLoggingFactory.provideHttpLoggingInterceptor() }
    single { OkHttpFactory.providesOkHttpClient(get()) }
    single { RetrofitFactory.createWebService<ApiService>(get(), BuildConfig.BASE_URL) }

}

val repositoryModule = module {

}

val viewModelModule = module {

}