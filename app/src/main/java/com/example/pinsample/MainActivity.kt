package com.example.pinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pinsample.custom.PinKeyListener
import com.example.pinsample.custom.PinTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var oneWatcher: PinTextWatcher
    private lateinit var twoWatcher: PinTextWatcher
    private lateinit var threeWatcher: PinTextWatcher
    private lateinit var fourWatcher: PinTextWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneWatcher = PinTextWatcher(edtTwo) {
            edtTwo.setOnKeyListener(null)
        }
        twoWatcher = PinTextWatcher(edtThree) {
            setSecondKeyListener()
        }
        threeWatcher = PinTextWatcher(edtFour) {
            setThirdKeyListener()
        }
        fourWatcher = PinTextWatcher(nextView = null) {
            setFourthKeyListener()
        }

        edtOne.addTextChangedListener(oneWatcher)

        edtTwo.addTextChangedListener(twoWatcher)

        edtThree.addTextChangedListener(threeWatcher)

        edtFour.addTextChangedListener(fourWatcher)
    }

    private fun setFourthKeyListener() {
        edtFour.setOnKeyListener(PinKeyListener(edtFour, edtThree, threeWatcher))
        edtThree.setOnKeyListener(null)
        edtTwo.setOnKeyListener(null)
        edtOne.setOnKeyListener(null)
    }
    private fun setThirdKeyListener() {
        edtFour.setOnKeyListener(null)
        edtThree.setOnKeyListener(PinKeyListener(edtThree, edtTwo, twoWatcher))
        edtTwo.setOnKeyListener(null)
        edtOne.setOnKeyListener(null)
    }
    private fun setSecondKeyListener() {
        edtFour.setOnKeyListener(null)
        edtThree.setOnKeyListener(null)
        edtTwo.setOnKeyListener(PinKeyListener(edtTwo, edtOne, oneWatcher))
        edtOne.setOnKeyListener(null)
    }



}
