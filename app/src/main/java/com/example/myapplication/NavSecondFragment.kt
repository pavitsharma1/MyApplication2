package com.example.myapplication

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentNavSecondBinding
import com.example.myapplication.jetpacknavitagtion.JetPackActivity


class NavSecondFragment : Fragment() {
    lateinit var binding: FragmentNavSecondBinding
    lateinit var ActivityNavigate: JetPackActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityNavigate = activity as JetPackActivity
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNavSecondBinding.inflate(layoutInflater)
        binding.btnSignNav2.setOnClickListener {
            if (binding.etUnmSign.text.toString().isEmpty()){
                binding.etUnmSign.error="Enter a name"
            }

            else if(binding.etPssSign.length()<8){
                    binding.etPssSign.error="Password must be atleast 8 characters"
                }

            else if (Patterns.EMAIL_ADDRESS.matcher(binding.etEmlSign.text).matches()) {
                ActivityNavigate.navController.navigate(R.id.action_navSecondFragment_to_navFirstFragment)
            }
            else{
                binding.etEmlSign.error="enter email id"
            }
        }
        return binding.root
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment NavSecondFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            NavSecondFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}