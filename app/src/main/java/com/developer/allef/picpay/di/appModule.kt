package com.developer.allef.picpay.di

import com.developer.allef.picpay.BuildConfig
import com.developer.allef.picpay.data.local.AppSharedPreferences
import com.developer.allef.picpay.data.repository.addnewcard.AddNewCardRepository
import com.developer.allef.picpay.data.repository.ContactRepository
import com.developer.allef.picpay.data.repository.addnewcard.AddNewCardInterface
import com.developer.allef.picpay.di.factory.OkHttpFactory
import com.developer.allef.picpay.di.factory.OkHttpLoggingFactory
import com.developer.allef.picpay.di.factory.RetrofitFactory
import com.developer.allef.picpay.service.ApiService
import com.developer.allef.picpay.ui.contact.ContactViewModel
import com.developer.allef.picpay.ui.credcard.addnewcard.AddNewCardViewModel
import org.koin.android.viewmodel.dsl.viewModel
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
    factory { AppSharedPreferences(context = get()) }
    factory { ContactRepository(prefs = get()) }
    factory<AddNewCardInterface> {
        AddNewCardRepository(
            prefs = get()
        )
    }


}

val viewModelModule = module {
    viewModel { ContactViewModel(get()) }
    viewModel { AddNewCardViewModel(get()) }
}