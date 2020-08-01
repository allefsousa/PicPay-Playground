package com.developer.allef.picpay.ui.contact

import android.util.Log
import androidx.lifecycle.*
import com.developer.allef.picpay.data.Contact
import com.developer.allef.picpay.data.ContactDTO
import com.developer.allef.picpay.data.toMapperListItem
import com.developer.allef.picpay.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author allef.santos on 31/07/20
 */
class ContactViewModel(private val service: ApiService) : ViewModel(), LifecycleObserver {

    val contacts = MutableLiveData<List<Contact>>().apply { value = emptyList() }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load() {
        service.getContacts().enqueue(object : Callback<List<ContactDTO>> {
            override fun onFailure(call: Call<List<ContactDTO>>, t: Throwable) {
                Log.d(ContactViewModel::class.java.simpleName, "getContacts - onFailure = " + t.localizedMessage)
            }

            override fun onResponse(call: Call<List<ContactDTO>>, response: Response<List<ContactDTO>>) {
                if (response.isSuccessful) {
                    response.body()?.let { contacts.value = it.toMapperListItem() }
                } else {
                    Log.d(ContactViewModel::class.java.simpleName, "response failure = " + response.code())
                }

            }
        })
    }

}