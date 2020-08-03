package com.developer.allef.picpay.data.repository.card

import com.developer.allef.picpay.data.model.CredCard

/**
 * @author allef.santos on 02/08/20
 */
interface NewCardRepository {

    fun saveUserCard(userCard: CredCard): Boolean
    fun claerUserCard(): Boolean
}