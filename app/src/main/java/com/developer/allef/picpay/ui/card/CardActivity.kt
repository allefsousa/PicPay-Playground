package com.developer.allef.picpay.ui.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.developer.allef.picpay.data.model.Contact
import com.developer.allef.picpay.databinding.ActivityCredCardBinding
import com.developer.allef.picpay.ui.card.newcard.NewCardActivity

class CardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCredCardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCredCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contact = intent.getParcelableExtra<Contact>("contact")

        binding.toolbar.toolbars.setNavigationOnClickListener {
            finish()
        }

        binding.btnPriming.btnPrimary.setOnClickListener {
           callActivity(contact,NewCardActivity::class.java)
        }


    }
    private fun callActivity(user: Contact, javaCls: Class<*>) {
        val intent = Intent(this, javaCls)
        intent.putExtra("contact", user)
        startActivity(intent)
        finish()
    }
}