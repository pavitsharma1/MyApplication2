package com.example.myapplication.jetpacknavitagtion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFragmentBinding
import com.example.myapplication.databinding.ActivityJetPackBinding

class JetPackActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetPackBinding
     lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityJetPackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.navigator)
        }
    }
