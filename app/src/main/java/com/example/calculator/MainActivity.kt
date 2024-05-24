package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculator.models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1: EditText
    lateinit var edtNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
    }

    fun buttonClick(v:View){
        var ans = 0.0
        val calculator =  Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )

        when(v.id){
            R.id.btn_Plus -> ans = calculator.add()
            R.id.btn_Minus -> ans = calculator.substract()
            R.id.btn_Multilpy -> ans = calculator.multiply()
            R.id.btn_Divide -> ans = calculator.divide()
        }

        println(ans)

        val intent = Intent(this,Display::class.java)
        intent.putExtra("answer",ans)
        startActivity(intent)
        finish()

    }



}