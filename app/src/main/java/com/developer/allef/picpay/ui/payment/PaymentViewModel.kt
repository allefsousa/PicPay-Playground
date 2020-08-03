package com.developer.allef.picpay.ui.payment

import android.text.Editable
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.allef.picpay.data.model.Contact

/**
 * @author allef.santos on 02/08/20
 */
class PaymentViewModel:ViewModel(),LifecycleObserver {

    val contact = MutableLiveData<Contact>()
    val controllerEnable = MutableLiveData<Boolean>()

    fun onAfterTextChange(s: Editable) {
        controllerEnable.value = !s.toString().isNullOrBlank()
    }
}