package edu.us.ischool.sseera.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.tipButton) as Button

        val amountRef = findViewById(R.id.amount) as EditText

        //Set a handler for amountRef to enable the tip button when it has good input
        // amountRef.
        button.setOnClickListener({view ->
            val amount:Double = (amountRef.getText().toString().toDouble())
            val TipDue:Double = TipCalc(amount);
            val toast = Toast.makeText(applicationContext, "$"+TipDue, Toast.LENGTH_SHORT);
                toast.show()

        })

    }

    fun TipCalc(amount: Double = 0.0, tip:Int = 15): Double{

        return amount * (tip /100.0);

    }


}
