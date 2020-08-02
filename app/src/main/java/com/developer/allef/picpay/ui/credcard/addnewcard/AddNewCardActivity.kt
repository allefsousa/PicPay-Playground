package com.developer.allef.picpay.ui.credcard.addnewcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.allef.picpay.databinding.ActivityAddNewCardBinding
import com.developer.allef.picpay.databinding.ActivityCredCardBinding

class AddNewCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}