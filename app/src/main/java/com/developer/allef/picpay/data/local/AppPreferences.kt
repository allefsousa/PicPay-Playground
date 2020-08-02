package com.developer.allef.picpay.data.local

import android.content.Context
import android.content.SharedPreferences
import java.util.prefs.Preferences

/**
 * @author allef.santos on 31/07/20
 */

class AppSharedPreferences(val context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_FILENAME, 0)

    companion object {
        const val PREFS_FILENAME = "com.developer.allef.picpay"
    }


}