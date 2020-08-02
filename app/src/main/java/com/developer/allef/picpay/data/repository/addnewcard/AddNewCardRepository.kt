package com.developer.allef.picpay.data.repository.addnewcard

import com.developer.allef.picpay.data.local.AppSharedPreferences
import com.developer.allef.picpay.data.model.CredCard
import com.developer.allef.picpay.data.repository.addnewcard.AddNewCardInterface
import com.google.gson.Gson




/**
 * @author allef.santos on 02/08/20
 */
class AddNewCardRepository(private val prefs: AppSharedPreferences): AddNewCardInterface {

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