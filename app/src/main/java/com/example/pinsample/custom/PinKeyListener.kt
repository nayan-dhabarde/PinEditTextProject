package com.example.pinsample.custom

import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText

class PinKeyListener(
    var curView: EditText?,
    var prevView: EditText?,
    var watcher: PinTextWatcher
): View.OnKeyListener {
    var count = 0

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_DEL) {
            Log.d("PinKeyListener", "backspace")
            curView?.let { curEditText ->
                if (curEditText.text?.isEmpty()!!) {
                    if(count == 1) {
                        prevView?.requestFocus()
                    }
                }
            }
            count ++

        }
        return false
    }
}