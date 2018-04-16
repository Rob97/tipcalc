package edu.us.ischool.sseera.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById(R.id.tipButton) as Button
        button.setOnClickListener{view ->
            toast.show()
        }

    }

    val TipDue:String = TipCalc().toString();

    val toast = Toast.makeText(applicationContext, TipDue, Toast.LENGTH_SHORT);

    fun TipCalc(amount: Double = 100.0, tip:Int = 15): Double{

        return amount * (tip /100);

    }


}
