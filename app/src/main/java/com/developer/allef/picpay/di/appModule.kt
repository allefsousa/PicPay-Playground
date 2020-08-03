package com.developer.allef.picpay.di

import com.developer.allef.picpay.BuildConfig
import com.developer.allef.picpay.data.local.AppSharedPreferences
import com.developer.allef.picpay.data.repository.card.AddNewCardRepositoryImp
import com.developer.allef.picpay.data.repository.contact.ContactRepositoryImp
import com.developer.allef.picpay.data.repository.card.NewCardRepository
import com.developer.allef.picpay.data.repository.contact.ContactRepository
import com.developer.allef.picpay.di.factory.OkHttpFactory
import com.developer.allef.picpay.di.factory.OkHttpLoggingFactory
import com.developer.allef.picpay.di.factory.RetrofitFactory
import com.developer.allef.picpay.service.ApiService
import com.developer.allef.picpay.ui.contact.ContactViewModel
import com.developer.allef.picpay.ui.card.newcard.NewCardViewModel
import com.developer.allef.picpay.ui.payment.PaymentViewModel
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
    factory <ContactRepository>{
        ContactRepositoryImp(
            prefs = get()
        )
    }
    factory<NewCardRepository> {
        AddNewCardRepositoryImp(
            prefs = get()
        )
    }


}

val viewModelModule = module {
    viewModel { ContactViewModel(get(),get()) }
    viewModel { NewCardViewModel(get()) }
    viewModel { PaymentViewModel() }
}