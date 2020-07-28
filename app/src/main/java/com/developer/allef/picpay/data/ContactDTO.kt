package com.developer.allef.picpay.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author allef.santos on 28/07/20
 */
@Parcelize
data class ContactDTO(val id: Int, val name: String, val img: String, val username: String) :
    Parcelable

fun ContactDTO.toContact() :Contact{
    return (Contact(
        id, name, img, username
    ))
}