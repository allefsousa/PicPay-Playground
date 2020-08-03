package com.developer.allef.picpay.ui.card.newcard

import android.text.Editable
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.allef.picpay.data.model.CredCard
import com.developer.allef.picpay.data.repository.card.NewCardRepository

/**
 * @author allef.santos on 02/08/20
 */
class NewCardViewModel(private val newContactRepository: NewCardRepository) :ViewModel(),LifecycleObserver {

    val credCardNumber = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val cvv = MutableLiveData<String>()
    val buttonVisible = MutableLiveData<Boolean>()

    init {
        buttonVisible.value = false
    }


    fun onAfterTextChange(s: Editable) {
        buttonVisible.value = (credCardNumber.value.toString().isNotEmpty() && name.value.toString().isNotEmpty() && date.value.toString().isNotEmpty() && cvv.value.toString().isNotEmpty())
    }

    fun saveCredCard(): Boolean {
        return newContactRepository.saveUserCard(
            CredCard(
                credCardNumber.value.toString(),
                name.value.toString(),
                cvv.value.toString()
            )
        )

    }
}