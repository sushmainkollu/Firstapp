package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rnum = randomNumber()
        var trails=0
      //  var msg:String

        val numeditText = findViewById(R.id.numeditText) as EditText
        //val picimageView = findViewById(R.id.picimageView) as ImageView
       // val titletextView2 = titletextView2.text
        val submitbutton = findViewById(R.id.submitbutton) as Button
        val resulttextView3 = findViewById(R.id.resulttextView3) as TextView
        val trailstextView = findViewById(R.id.trailstextView) as TextView

         submitbutton.setOnClickListener() {

            val num1 = numeditText.text.toString()

            if(num1.isEmpty())
             {
                 Toast.makeText(applicationContext,"Please Enter the number",Toast.LENGTH_SHORT ).show()
                 return@setOnClickListener
             }

             //To check if the enetered number is higher or lower than the random number

            if (rnum > Integer.parseInt(num1)) {
               // Toast.makeText( applicationContext,"The number is High. Try Again" + rnum,Toast.LENGTH_SHORT).show()
                 resulttextView3.setText(R.string.too_low).toString()
                trails++

            } else
                if (rnum < Integer.parseInt(num1)) {
                   // Toast.makeText(applicationContext, "The number is too Low. Try Again" + rnum, Toast.LENGTH_SHORT).show()
                   resulttextView3.setText(R.string.too_high).toString()
                    trails++


                } else {
                    //Toast.makeText(applicationContext, "Congratulations!!" + rnum+"in no. of trails" + trails, Toast.LENGTH_SHORT).show()
                     resulttextView3.setText(R.string.congrats).toString()
                    trailstextView.setText("Trails : " +trails )
                    trails=0
                    rnum = randomNumber()
                    return@setOnClickListener
                    
                }

            // Log.i("Random Number",Integer.toString(randomNumber()))
             Log.i("Entered Number",num1)
             //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }
    }

    //Function to call random numbers

           fun randomNumber(): Int {
                return Random().nextInt(100)
                //resulttextView3.setText(R.string.start_msg)
            }



}


