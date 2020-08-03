package com.developer.allef.picpay.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.developer.allef.picpay.R
import com.developer.allef.picpay.data.model.Contact
import com.developer.allef.picpay.databinding.ActivityAddNewCardBinding
import com.developer.allef.picpay.databinding.ActivityPaymentBinding
import com.developer.allef.picpay.ui.card.newcard.NewCardActivity
import com.developer.allef.picpay.ui.card.newcard.NewCardViewModel
import com.developer.allef.picpay.ui.payment.paymentdialog.CompletePaymentDialog
import org.koin.android.ext.android.inject

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private val viewModel: PaymentViewModel by inject()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDataBinding()
        setContentView(binding.root)

        val contact = intent.getParcelableExtra<Contact>("contact")
        viewModel.contact.value =  contact

        binding.newtoolbar.toolbars.setNavigationOnClickListener {
            finish()
        }

        binding.btnEdit.setOnClickListener {
            callActivity(contact,NewCardActivity::class.java)
        }

        binding.btnPayment.setOnClickListener {
            CompletePaymentDialog.newInstance().show(supportFragmentManager,"TAG")
        }




    }

    private fun loadDataBinding() {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        this.lifecycle.addObserver(viewModel)
    }

    private fun callActivity(user: Contact, javaCls: Class<*>) {
        val intent = Intent(this, javaCls)
        intent.putExtra("contact", user)
        startActivity(intent)
        finish()
    }
}