package com.example.myapplication.numberlistactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityColorNumberBinding

class ColorNumberActivity : AppCompatActivity() {
    lateinit var binding: ActivityColorNumberBinding
    lateinit var clrAdap: ColorRvAdapter
    var clrarray= ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityColorNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var i=binding.colorEt1.text
        clrAdap= ColorRvAdapter(clrarray)
        binding.colorLv1.layoutManager = LinearLayoutManager(this)
        binding.colorLv1.adapter=clrAdap
      binding.btnColor1.setOnClickListener {
          for ( x in 1..i.toString().toInt()  ) {
              clrarray.add(x)
              clrAdap.notifyDataSetChanged()
          }
      }
    }
}