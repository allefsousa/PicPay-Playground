package com.developer.allef.picpay.data.local

import android.content.Context
import android.content.SharedPreferences

/**
 * @author allef.santos on 31/07/20
 */

class AppSharedPreferences(val context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_FILENAME, 0)

    companion object {
        const val PREFS_FILENAME = "com.developer.allef.picpay"
        const val USER_CARD = "user_card"
    }

    var userCard: String
        get() {
            return sharedPreferences.getString(USER_CARD, "").toString()
        }
        set(value) {
            sharedPreferences.edit().putString(USER_CARD, value).apply()
        }


}