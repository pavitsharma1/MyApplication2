package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtsignup: TextView
    lateinit var IDpss: EditText
    lateinit var Btnlogin: Button
    lateinit var Pss: EditText
    lateinit var Forgot: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        txtsignup=findViewById(R.id.signup)
        IDpss=findViewById(R.id.entrid)
        Pss=findViewById(R.id.entrpss)
        Btnlogin=findViewById(R.id.loginbutton)
       Forgot=findViewById(R.id.forgotpass)
        Btnlogin.setOnClickListener {
            if (IDpss.text.toString().isEmpty())
            {IDpss.error="no name"}
            else if (Pss.text.toString().isEmpty())
            {Pss.error="no pass"}
            else{
                startActivity(Intent(this,Homepage::class.java))
            }

        }
        txtsignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
       Forgot.setOnClickListener {

           startActivity(Intent(this, SignupActivity::class.java))
       }
    }



}