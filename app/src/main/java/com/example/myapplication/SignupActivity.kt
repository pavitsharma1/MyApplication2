package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    lateinit var signupid:EditText
    lateinit var signuppass: EditText
    lateinit var signupbutton: Button
    lateinit var haveacc: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        signupid=findViewById(R.id.sgnup_id)
        signuppass=findViewById(R.id.sgnup_pass)
        signupbutton=findViewById(R.id.btnsignup)
        haveacc=findViewById(R.id.haveanacc)

        haveacc.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        signupbutton.setOnClickListener {
            if (signupid.text.toString().isEmpty())
            {signupid.error="no id"
                Toast.makeText(this,"no id",Toast.LENGTH_SHORT).show()}
            else if (signuppass.text.toString().isEmpty())
            {signuppass.error="no pass"
                Toast.makeText(this,"no password",Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,Homepage::class.java))
            }
        }
    }

}