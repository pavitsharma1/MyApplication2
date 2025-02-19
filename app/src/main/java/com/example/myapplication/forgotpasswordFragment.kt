package com.example.myapplication

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentForgotpasswordBinding
import com.example.myapplication.databinding.FragmentOtpBinding
import com.example.myapplication.jetpacknavitagtion.JetPackActivity
class forgotpasswordFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding: FragmentForgotpasswordBinding
    lateinit var ActivityNavigate: JetPackActivity
    lateinit var otpFragment: otpFragment
    lateinit var addemail: addemail

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
        // Inflate the layout for this fragment
        binding= FragmentForgotpasswordBinding.inflate(layoutInflater)
        binding.btnOtp.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(binding.emlOtp.text).matches())
            {
                var bundle=Bundle()
                bundle.putString("email",binding.emlOtp.text.toString())
                ActivityNavigate.navController.navigate(R.id.action_forgotpasswordFragment_to_otpFragment,bundle)
            }
            else{binding.emlOtp.error="Enter valid email"}
        }
        return binding.root
    }
}