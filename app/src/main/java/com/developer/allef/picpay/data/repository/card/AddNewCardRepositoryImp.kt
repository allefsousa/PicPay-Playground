package com.developer.allef.picpay.data.repository.card

import com.developer.allef.picpay.data.local.AppSharedPreferences
import com.developer.allef.picpay.data.model.CredCard
import com.google.gson.Gson




/**
 * @author allef.santos on 02/08/20
 */
class AddNewCardRepositoryImp(private val prefs: AppSharedPreferences): NewCardRepository {

    override fun saveUserCard(userCard:CredCard): Boolean {
        val gson = Gson()
        val json = gson.toJson(userCard)
        prefs.userCard = json
        return true
    }

    override fun claerUserCard(): Boolean {
        prefs.userCard = ""
        return true
    }

}