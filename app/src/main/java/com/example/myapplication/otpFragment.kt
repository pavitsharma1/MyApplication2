package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.ActivityNavigator
import com.example.myapplication.databinding.FragmentOtpBinding
import com.example.myapplication.jetpacknavitagtion.JetPackActivity


class otpFragment : Fragment() {

     lateinit var binding: FragmentOtpBinding
     lateinit var ActivityNavigate: JetPackActivity
     lateinit var addemail: addemail
     lateinit var forgotpasswordFragment: forgotpasswordFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityNavigate=activity as JetPackActivity
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOtpBinding.inflate(layoutInflater)
        binding.otpLogin.setOnClickListener {
            if (binding.otpEt1.text.toString().isEmpty()
                ){
                binding.otpEt4.error="enter otp"
            }
            else if (binding.otpEt2.text.toString().isEmpty()
            ){
                binding.otpEt4.error="enter otp"
            }
            else if (binding.otpEt3.text.toString().isEmpty()
            ){
                binding.otpEt4.error="enter otp"
            }
            else if(binding.otpEt4.text.toString().isEmpty()
            ){
                binding.otpEt4.error="enter otp"
            }
            else{
            ActivityNavigate.navController.navigate(R.id.action_otpFragment_to_navThirdFragment)
                forgotpasswordFragment.createfun3(binding.emlIdPrinter.text.toString())
        }
        }
        binding.otpEt1.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {}

            override fun afterTextChanged(p0: Editable?) {
                if(binding.otpEt1.length()==1){
                    binding.otpEt2.requestFocus()
                }
            }

        })
        binding.otpEt2.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(binding.otpEt2.length()==1){
                    binding.otpEt3.requestFocus()
                }
            }

        })
        binding.otpEt3.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            }

            override fun afterTextChanged(p0: Editable?) {
           if( binding.otpEt3.length()==1){
               binding.otpEt4.requestFocus()
           }
            }
        })
        return binding.root
    }


//    override fun addtxt2(txteml: String){
//        binding.emlIdPrinter.setText(txteml)
//    }


}