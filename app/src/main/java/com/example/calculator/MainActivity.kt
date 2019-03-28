package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ops = "*"
    var newOperation = true
    var oldNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   fun buNumClickEvent(view: View) {

        val buSelect = view as Button
        if(newOperation) {
           etShowValue.setText("")
           newOperation = false
        }
        var buClickValue: String = etShowValue.text.toString()

        when(buSelect.id) {
            bu0.id->{
                buClickValue += "0"
            }
            bu1.id->{
                buClickValue += "1"
            }
            bu2.id->{
                buClickValue += "2"
            }
            bu3.id->{
                buClickValue += "3"
            }
            bu4.id->{
                buClickValue += "4"
            }
            bu5.id->{
                buClickValue += "5"
            }
            bu6.id->{
                buClickValue += "6"
            }
            bu7.id->{
                buClickValue += "7"
            }
            bu8.id->{
                buClickValue += "8"
            }
            bu9.id->{
                buClickValue += "9"
            }
            buDot.id->{
                //Todo prevent adding more dots
                buClickValue += "."
            }
        }

       etShowValue.setText(buClickValue)
   }

    fun buOperation(view: View) {
        newOperation = true
        val buSelect = view as Button

        when(buSelect.id) {
            buDivide.id -> {
                ops = "/"
            }
            buMultiply.id -> {
                ops = "*"
            }
            buPlus.id -> {
                ops = "+"
            }
            buMinus.id -> {
                ops = "-"
            }
        }
        oldNumber = etShowValue.text.toString()
    }

    fun findResult(view: View) {
        var result: Double? = null
        val newNumber = etShowValue.text.toString()
        when(ops) {
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()

            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()

            }
        }

        etShowValue.setText(result.toString())
    }

}
