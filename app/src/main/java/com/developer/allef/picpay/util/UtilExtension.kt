package com.developer.allef.picpay.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * @author allef.santos on 28/07/20
 */

fun EditText.addMask(mask:String) {
    var isUpdating = false
    var old = ""
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val str: String = unmask(s.toString()).toString()
            var mascara = ""
            if (isUpdating) {
                old = str
                isUpdating = false
                return
            }
            var i = 0
            for (m in mask.toCharArray()) {
                if (m != '#' && str.length > old.length) {
                    mascara += m
                    continue
                }
                mascara += try {
                    str[i]
                } catch (e: Exception) {
                    break
                }
                i++
            }
            isUpdating = true
            this@addMask.setText(mascara)
            this@addMask.setSelection(mascara.length)
        }

        fun unmask(s: String): String? {
            return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
                .replace("[/]".toRegex(), "")
                .replace("[(]".toRegex(), "").replace("[ ]".toRegex(), "").replace("[:]".toRegex(), "")
                .replace("[)]".toRegex(), "")
        }
    })



}
fun EditText.textChange(textChange: (String) -> Unit) {

    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textChange(s.toString())
        }
    })

}


//val mapType = HashMap<String, String>()
//mapType["visa"] = "^4[0-9]{6,}$"
//mapType["MasterCard"] = "^5[1-5][0-9]{5,}$"
//mapType["American Express"] = "^3[47][0-9]{5,}$"
//mapType["Diners Club"] = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$"
//mapType["Discover"] = "^6(?:011|5[0-9]{2})[0-9]{3,}$"
//mapType["JCB"] = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$"