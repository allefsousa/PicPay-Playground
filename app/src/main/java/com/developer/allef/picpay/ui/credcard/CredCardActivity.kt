package com.developer.allef.picpay.ui.credcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.allef.picpay.R
import com.developer.allef.picpay.data.local.AppSharedPreferences
import com.developer.allef.picpay.databinding.ActivityContactBinding
import com.developer.allef.picpay.databinding.ActivityCredCardBinding
import com.developer.allef.picpay.ui.credcard.addnewcard.AddNewCardActivity
import org.koin.android.ext.android.inject

class CredCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCredCardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCredCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.toolbars.setNavigationOnClickListener {
            finish()
        }

        binding.btnPriming.btnPrimary.setOnClickListener {
            startActivity(Intent(this,AddNewCardActivity::class.java))
        }
    }
}