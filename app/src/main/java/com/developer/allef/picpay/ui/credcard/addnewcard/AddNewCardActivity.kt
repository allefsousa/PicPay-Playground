package com.developer.allef.picpay.ui.credcard.addnewcard

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import com.developer.allef.picpay.databinding.ActivityAddNewCardBinding
import com.developer.allef.picpay.util.addMask
import org.koin.android.ext.android.inject

class AddNewCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewCardBinding
    private val viewModel: AddNewCardViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDataBinding()
        setContentView(binding.root)

        loadActions()

        loadComponents()
    }

    private fun loadDataBinding() {
        binding = ActivityAddNewCardBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        this.lifecycle.addObserver(viewModel)
    }

    private fun loadComponents() {
        binding.edCredNumber.addMask("#### #### #### ####")
        binding.edVenc.addMask("##/####")
    }

    private fun loadActions() {
        binding.newtoolbar.toolbars.setNavigationOnClickListener {
            finish()
        }
        binding.edCvv.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                updateUI()
            }
        }
        binding.edName.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                updateUI()
            }
        }
    }

    private fun updateUI() {
        binding.containerScroll.viewTreeObserver
            .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    val scrollViewHeight = binding.containerScroll.height
                    if (scrollViewHeight > 0) {
                        binding.containerScroll.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        val lastView =
                            binding.containerScroll.getChildAt(binding.containerScroll.childCount - 1)
                        val lastViewBottom = lastView.bottom + binding.containerScroll.paddingBottom
                        val deltaScrollY =
                            lastViewBottom - scrollViewHeight - binding.containerScroll.scrollY
                        binding.containerScroll.smoothScrollBy(0, deltaScrollY)
                        binding.containerScroll.scrollBy(0, deltaScrollY)
                    }
                }
            })
    }
}