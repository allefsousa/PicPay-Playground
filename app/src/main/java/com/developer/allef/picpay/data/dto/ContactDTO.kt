package com.developer.allef.picpay.data.dto

import android.os.Parcelable
import com.developer.allef.picpay.data.model.Contact
import kotlinx.android.parcel.Parcelize

/**
 * @author allef.santos on 28/07/20
 */
@Parcelize
data class ContactDTO(val id: Int, val name: String, val img: String, val username: String) :
    Parcelable

internal fun <E> List<E>.toMapperListItem(): List<Contact> {
    val listItem = mutableListOf<Contact>()
    this.forEach {
        when (it) {
            is ContactDTO -> {
                listItem.add(it.toContact())
            }
        }
    }
    return listItem
}

internal fun ContactDTO.toContact() : Contact {
    return (Contact(
        id, name, img, username
    ))
}