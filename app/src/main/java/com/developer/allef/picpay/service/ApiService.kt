package com.developer.allef.picpay.service

import com.developer.allef.picpay.data.dto.ContactDTO
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author allef.santos on 28/07/20
 */

interface ApiService {
    @GET("users")
    fun getContacts(): Call<List<ContactDTO>>
}