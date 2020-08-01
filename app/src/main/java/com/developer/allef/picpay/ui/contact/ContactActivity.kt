package com.developer.allef.picpay.ui.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.developer.allef.picpay.R
import com.developer.allef.picpay.data.Contact
import com.developer.allef.picpay.databinding.ActivityContactBinding
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
        Toast.makeText(this, "Sucesso click $contact", Toast.LENGTH_SHORT).show()
    }


}