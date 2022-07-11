package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView =findViewById<TextView>(R.id.Hello_tv)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btn)
        val offerButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
       // enteredName = inputField.text.toString()
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()
            if (enteredName == "") {
                offerButton.visibility  = INVISIBLE
                Toast.makeText(this@MainActivity,
                    "please enter your name",
                    Toast.LENGTH_SHORT).show()
                greetingTextView.text= ""
            }
            else {
                //val enteredName = inputField.text.toString()
                val message = "Welcome $enteredName"
                //display the text
                greetingTextView.text = message
                inputField.text.clear()
                offerButton.visibility = VISIBLE
            }
        }
        offerButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER","$enteredName")
            startActivity(intent)
        }
    }
}