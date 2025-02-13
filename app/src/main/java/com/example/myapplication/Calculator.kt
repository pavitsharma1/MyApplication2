package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import android.widget.Toast

import com.google.android.material.snackbar.Snackbar
import com.example.myapplication.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding
    var y:Any?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonadd.setOnClickListener {
            if (binding.value1.text.toString().isEmpty()){
                binding.value1.error="no value"
            }
               else if
                (binding.value2.text.toString().isEmpty()){
                    binding.value2.error="no value"
                }
                else{
                    var val1 = binding.value1.text.toString().toDouble()
                    var val2 = binding.value2.text.toString().toDouble()
                    y = (val1 + val2)
                    binding.resultcalc.text = y.toString()}
        }
        binding.buttonmultiply.setOnClickListener {
            if (binding.value1.text.toString().isEmpty()){
                binding.value1.error="no value"
            }
            else if
                         (binding.value2.text.toString().isEmpty()){
                binding.value2.error="no value"
            }
            else {
                var val1 = binding.value1.text.toString().toDouble()
                var val2 = binding.value2.text.toString().toDouble()
                y = (val1 * val2)
                binding.resultcalc.text = y.toString()
            }
        }
        binding.buttondivide.setOnClickListener {
            if (binding.value1.text.toString().isEmpty()){
                binding.value1.error="no value"
            }
            else if (binding.value2.text.toString().isEmpty()){
                binding.value2.error="no value"
            }
            else{
            var val1 = binding.value1.text.toString().toDouble()
            var val2 = binding.value2.text.toString().toDouble()
            y = (val1 / val2)

            binding.resultcalc.text = y.toString() }
        }
        binding.buttonminus.setOnClickListener {
            if (binding.value1.text.toString().isEmpty()){
                binding.value1.error="no value"
            }
            else if
                         (binding.value2.text.toString().isEmpty()){
                binding.value2.error="no value"
            }
            else {
                var val1 = binding.value1.text.toString().toDouble()
                var val2 = binding.value2.text.toString().toDouble()
                y = (val1 - val2)
                binding.resultcalc.text = y.toString()
            }
        }
    }



    }
