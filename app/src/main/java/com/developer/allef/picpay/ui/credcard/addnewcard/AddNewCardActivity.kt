package com.developer.allef.picpay.ui.credcard.addnewcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.developer.allef.picpay.databinding.ActivityAddNewCardBinding
import com.developer.allef.picpay.databinding.ActivityCredCardBinding

class AddNewCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.componentToolbar.setNavigationOnClickListener {
            finish()
        }
        binding.edCredNumber.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
}