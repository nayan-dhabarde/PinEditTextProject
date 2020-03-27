package com.example.pinsample.custom

import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText

class PinKeyListener(var curView: EditText?, var prevView: EditText?): View.OnKeyListener {

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_DEL) {
            Log.d("PinKeyListener", "backspace")
            curView?.let { curEditText ->
                if (curEditText.text?.isEmpty()!!) {
                    prevView?.text?.clear()
                    prevView?.requestFocus()
                }
            }
        }
        return false
    }
}