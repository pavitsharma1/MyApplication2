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

class constraintactivity : AppCompatActivity() {
      lateinit var txtblack: TextView
      lateinit var txtred: TextView
      lateinit var txtblue: TextView
      lateinit var txtskin: TextView
      lateinit var txtyellow: TextView
      lateinit var txtorange: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraintactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtblack=findViewById(R.id.blackbox)
        txtred=findViewById(R.id.redbox)
        txtskin=findViewById(R.id.skinbox)
        txtblue=findViewById(R.id.bluebox)
        txtyellow=findViewById(R.id.yellowbox)
        txtorange=findViewById(R.id.orangebox)

        txtblack.setOnClickListener {
            var intent = Intent(this, blackbox::class.java)
                intent.putExtra("value",0)
            startActivity(intent)
        }
        txtred.setOnClickListener {
            startActivity(Intent(this, Redbox::class.java))
        }
        txtskin.setOnClickListener {
            startActivity(Intent(this, skinbox::class.java))
        }
        txtblue.setOnClickListener {
            startActivity(Intent(this, Redbox::class.java))
        }
        txtyellow.setOnClickListener {
            startActivity(Intent(this, blackbox::class.java))
        }
        txtorange.setOnClickListener {
            startActivity(Intent(this, Redbox::class.java))
        }

    }
}