package com.developer.allef.picpay.data.repository.contact

import com.developer.allef.picpay.data.local.AppSharedPreferences

/**
 * @author allef.santos on 02/08/20
 */
class ContactRepositoryImp(private val prefs: AppSharedPreferences):ContactRepository {

     override fun getUserHasCard(): Boolean {
        return prefs.userCard.isNotEmpty()
    }

}