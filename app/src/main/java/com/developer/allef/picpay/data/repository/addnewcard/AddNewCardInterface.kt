package com.developer.allef.picpay.data.repository.addnewcard

import com.developer.allef.picpay.data.model.CredCard

/**
 * @author allef.santos on 02/08/20
 */
interface AddNewCardInterface {

    fun saveUserCard(userCard: CredCard): Boolean
}