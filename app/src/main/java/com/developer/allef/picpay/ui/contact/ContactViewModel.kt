package com.developer.allef.picpay.ui.contact

import android.util.Log
import androidx.lifecycle.*
import com.developer.allef.picpay.data.model.Contact
import com.developer.allef.picpay.data.dto.ContactDTO
import com.developer.allef.picpay.data.dto.toMapperListItem
import com.developer.allef.picpay.data.repository.contact.ContactRepository
import com.developer.allef.picpay.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author allef.santos on 31/07/20
 */
class ContactViewModel(
    private val service: ApiService,
    private val contactRepository: ContactRepository
) : ViewModel(){

    private val _contacts = MutableLiveData<List<Contact>>().apply { value = emptyList() }
    private val _userHasCard = MutableLiveData<Boolean>().apply { value = false }

    val userHasCard:LiveData<Boolean> get() = _userHasCard
    val contacts:LiveData<List<Contact>> get() =_contacts
    init {
        isSavedCard()
    }

    fun load() {
        service.getContacts().enqueue(object : Callback<List<ContactDTO>> {

            override fun onResponse(call: Call<List<ContactDTO>>, response: Response<List<ContactDTO>>) {
                if (response.isSuccessful) {
                    response.body()?.let { _contacts.value = it.toMapperListItem() }
                } else {
                    Log.d(ContactViewModel::class.java.simpleName, "response failure = " + response.code())
                }

            }

            override fun onFailure(call: Call<List<ContactDTO>>, t: Throwable) {
                Log.d(ContactViewModel::class.java.simpleName, "getContacts - onFailure = " + t.localizedMessage)
            }
        })
    }

    private fun isSavedCard(){
        val result = contactRepository.getUserHasCard()
        _userHasCard.value = result
    }

}