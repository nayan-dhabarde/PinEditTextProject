package com.example.pinsample.custom

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class PinTextWatcher(var nextView: EditText?, var onFinish: () -> Unit = {}): TextWatcher {

    override fun afterTextChanged(s: Editable?) {
        s?.let {
            if(s.isNotEmpty()) {
                nextView?.requestFocus()
            } else {
                onFinish()
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

}