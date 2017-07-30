package com.example.taginstore.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var op="+"
    var oldNumber=""
    var isNewOp=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btNumberEvent(view:View) {
        try {
            if (isNewOp) {tvDisplay.setText("")}
            isNewOp=false
            val btSelected = view as Button
            var btClickValue: String = ""

                if (tvDisplay.text.toString() == "0" &&  btSelected.id!=btPoint.id && btSelected.id!=btSign.id) {

                } else {
                    btClickValue = tvDisplay.text.toString()
                }
            when (btSelected.id) {
                bt0.id -> btClickValue += "0"
                bt1.id -> btClickValue += "1"
                bt2.id -> btClickValue += "2"
                bt3.id -> btClickValue += "3"
                bt4.id -> btClickValue += "4"
                bt5.id -> btClickValue += "5"
                bt6.id -> btClickValue += "6"
                bt7.id -> btClickValue += "7"
                bt8.id -> btClickValue += "8"
                bt9.id -> btClickValue += "9"
                btPoint.id -> {
                    if (!btClickValue.contains(".")) {
                        if (btClickValue.get(btClickValue.length - 1) == '.') {
                            btClickValue.substring(btClickValue.length - 1)
                        } else
                            btClickValue += "."
                    } else {

                    }
                }
                btSign.id -> {
                    if (btClickValue.contains("-")) {
                        btClickValue.replace("-", "")
                    } else if(btClickValue!="0")
                        btClickValue = "-" + btClickValue
                }
                else -> {

                }
            }
            tvDisplay.setText(btClickValue)
        } catch(ex: Exception) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }

    }

    fun btDotEvent(view:View) {

    }

    fun btReset(view:View) {
        tvDisplay.setText("0")

    }
    fun btOp(view:View) {
        try {
            val btSelected = view as Button
            var btClickValue: String = ""

            when (btSelected.id) {
                btMuti.id -> op= "*"
                btPlus.id -> op= "+"
                btDiv.id -> op= "/"
                btMinus.id -> op= "-"
                btEqual.id -> op= "="


                else -> {

                }
                }



        }
        catch(ex:Exception) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
        oldNumber=tvDisplay.text.toString()
        isNewOp=true


    }

    fun btEqual(view: View){
        var newNumber = tvDisplay.text.toString()
        var result:Double?=null
        when(op){
            "*"->{
                result = newNumber.toDouble() * oldNumber.toDouble()
            }
            "-"->{
                result = newNumber.toDouble() * oldNumber.toDouble()
            }
            "+"->{
                result = newNumber.toDouble() * oldNumber.toDouble()
            }
            "/"->{
                result = newNumber.toDouble() * oldNumber.toDouble()
            }
        }
        tvDisplay.setText(result.toString())
        isNewOp = true
    }
}
