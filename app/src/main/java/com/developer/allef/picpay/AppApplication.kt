package com.developer.allef.picpay

import android.app.Application
import com.developer.allef.picpay.di.appModule
import com.developer.allef.picpay.di.networkModule
import com.developer.allef.picpay.di.repositoryModule
import com.developer.allef.picpay.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author allef.santos on 28/07/20
 */
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(appModule,viewModelModule, repositoryModule,networkModule)
        }

    }
}