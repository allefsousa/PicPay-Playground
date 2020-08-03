package com.developer.allef.picpay.ui.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.developer.allef.picpay.data.model.Contact
import com.developer.allef.picpay.databinding.ActivityContactBinding
import com.developer.allef.picpay.ui.card.CardActivity
import com.developer.allef.picpay.ui.payment.PaymentActivity
import org.koin.android.ext.android.inject

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactBinding

    private val contactAdapter by lazy {
        ContactAdapter{ contact -> contactClick(contact)}
    }
    private val viewModel:ContactViewModel by inject ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.load()


        binding.recyclerviewContacts.adapter = contactAdapter

        viewModel.contacts.observe(this, Observer {
            contactAdapter.addItems(it)
        })


    }

    private fun contactClick(contact: Contact) {
        viewModel.userHasCard.observe(this, Observer {
            if (it){
                callActivity(contact,PaymentActivity::class.java)

            }else{
                callActivity(contact,CardActivity::class.java)

            }
        })
    }

    private fun callActivity(user: Contact, javaCls: Class<*>) {
        val intent = Intent(this, javaCls)
        intent.putExtra("contact", user)
        startActivity(intent)
    }


}