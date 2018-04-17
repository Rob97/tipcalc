package edu.us.ischool.sseera.tipcalc

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.tipButton) as Button

        val amountRef = findViewById(R.id.amount) as EditText
amountRef.setRawInputType(Configuration.KEYBOARD_12KEY);
        //Set a handler for amountRef to enable the tip button when it has good input
        // amountRef.
        amountRef.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(arg0: Editable) {
                if(amountRef.getText().toString().length > 0){
                    button.setEnabled(true)
                }

//                var current = ""
//                var s = amountRef.getText().toString();
//                if (s.toString() != current){
//                    amountRef.removeTextChangedListener(this);
//
//                    var  cleanString: String = s.toString().substring( 1);
//                    var parsed:Double = cleanString.toDouble();
//                    var formatted:String = NumberFormat.getCurrencyInstance().format(parsed);
//
//                    current = formatted;
//                    amountRef.setText(formatted);
//                    amountRef.setSelection(formatted.length);
//
//                    amountRef.addTextChangedListener(this);
//                }



            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                 var current = ""
                if (s.toString() != current)
                {
                    amountRef.removeTextChangedListener(this)
                    val cleanString = s.toString().replace(("[$,.]").toRegex(), "")
                    val parsed = java.lang.Double.parseDouble(cleanString)
                    val formatted = NumberFormat.getCurrencyInstance().format((parsed / 100))
                    current = formatted
                    amountRef.setText(formatted)
                    amountRef.setSelection(formatted.length)
                    amountRef.addTextChangedListener(this)
                }


            }
        })


        button.setOnClickListener({view ->
            var amountString:String = (amountRef.getText().toString().replace(("[$,.]").toRegex(), ""))
            var amount:Double = java.lang.Double.parseDouble(amountString) /100
            var TipCalculated = (TipCalc(amount));
            println("TipCalculated" + TipCalculated)
            val tipMultiplied =  TipCalculated * 100
            println("tipMultiplied" + tipMultiplied)
            val tipFloat:Float = tipMultiplied.toFloat()
            println("tipFloat" + tipFloat)
            var tipRounded:Int = Math.round(tipFloat)
            println("tipRounded" + tipRounded)
            var TipDue:Double = (tipRounded.toDouble()/100)


           // var TipDue:Long = Math.round((TipCalc(amount)*100))/100

            var toast = Toast.makeText(applicationContext, "$"+TipDue, Toast.LENGTH_LONG);
                toast.show()

        })

    }

    fun TipCalc(amount: Double = 0.0, tip:Int = 15): Double{

        return amount * (tip /100.0);

    }


}
