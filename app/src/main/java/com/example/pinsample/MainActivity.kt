package com.example.pinsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pinsample.custom.PinKeyListener
import com.example.pinsample.custom.PinTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtOne.addTextChangedListener(PinTextWatcher(edtTwo) {
            edtTwo.setOnKeyListener(PinKeyListener(null, edtOne))
        })

        edtTwo.addTextChangedListener(PinTextWatcher(edtThree) {
            edtFour.setOnKeyListener(null)
            edtThree.setOnKeyListener(null)
            edtTwo.setOnKeyListener(PinKeyListener(edtTwo, edtOne))
            edtOne.setOnKeyListener(null)
        })

        edtThree.addTextChangedListener(PinTextWatcher(edtFour) {
            edtFour.setOnKeyListener(null)
            edtThree.setOnKeyListener(PinKeyListener(edtThree, edtTwo))
            edtTwo.setOnKeyListener(null)
            edtOne.setOnKeyListener(null)
        })

        edtFour.addTextChangedListener(PinTextWatcher(nextView = null) {
            edtFour.setOnKeyListener(PinKeyListener(edtFour, edtThree))
            edtThree.setOnKeyListener(null)
            edtTwo.setOnKeyListener(null)
            edtOne.setOnKeyListener(null)
        })

        edtFour.setOnFocusChangeListener { v, hasFocus ->
            print("changed")
        }
    }


}
