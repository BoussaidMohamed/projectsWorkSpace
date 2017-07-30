package com.example.taginstore.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     /*   tvDisplayBirthDate.setOnClickListener(View.OnClickListener {
            tvDisplayAge.setText("Your age shows here : ")
        })*/
    }
     fun btClaculateMyAgeOnClick(view:View){
        val userDOB:String = tvDisplayBirthDate.text.toString()
        val year:Int = Calendar.getInstance().get((Calendar.YEAR))
        val myAge:Int = year - userDOB.toInt()
        tvDisplayAge.text = "Your age is : $myAge"

    }
}
