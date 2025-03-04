package com.example.myapplication.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.navigation.findNavController
import com.example.myapplication.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavigationBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.navHost)
        binding.btmNav1.setOnItemSelectedListener {
            when(it.itemId){
                R.id.odrHistoryItem->{navController.navigate(R.id.orderHistoryFragment)
                }
                R.id.costumerDataItem->{
                    navController.navigate(R.id.customerDataFragment)
                }
                R.id.stockManagerItem->{
                    navController.navigate(R.id.stockFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}