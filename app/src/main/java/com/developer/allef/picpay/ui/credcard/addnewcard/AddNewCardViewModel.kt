package com.developer.allef.picpay.ui.credcard.addnewcard

import android.text.Editable
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.allef.picpay.data.model.CredCard
import com.developer.allef.picpay.data.repository.addnewcard.AddNewCardInterface

/**
 * @author allef.santos on 02/08/20
 */
class AddNewCardViewModel(private val addnewContactRepository: AddNewCardInterface) :ViewModel(),LifecycleObserver {

    val credCardNumber = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val cvv = MutableLiveData<String>()
    val buttonVisible = MutableLiveData<Boolean>()

    init {
        buttonVisible.value = false
    }


    fun onAfterTextChange(s: Editable) {
        buttonVisible.value =
            (!credCardNumber.value.toString().isBlank() && !name.value.toString().isBlank() && !date.value.toString().isBlank() && !cvv.value.toString().isBlank())
    }

    fun saveCredCard(): Boolean {
        return addnewContactRepository.saveUserCard(
            CredCard(
                credCardNumber.value.toString(),
                name.value.toString(),
                cvv.value.toString()
            )
        )

    }
}