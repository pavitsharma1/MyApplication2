package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.util.Patterns
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.FragmentNavFirstBinding
import com.example.myapplication.jetpacknavitagtion.JetPackActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavFirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavFirstFragment : Fragment() {
     lateinit var binding: FragmentNavFirstBinding
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
        binding = FragmentNavFirstBinding.inflate(layoutInflater)
        binding.btnNavOne.setOnClickListener{
            if(binding.etId.text.toString().isEmpty()){
                binding.etId.error="add id"
            }

            else if (binding.etPss.text.toString().isEmpty()){
                binding.etPss.error="add password" }

            else if(binding.etPss.length()<8){
                binding.etPss.error="Password must be atleast 8 characters"
            }
            else if (Patterns.EMAIL_ADDRESS.matcher(binding.etId.text).matches())
            {
                ActivityNavigate.navController?.navigate(R.id.action_navFirstFragment_to_navThirdFragment)}
            else{
                binding.etId.error="enter right email"
            }

        }
        binding.btnNavTwo.setOnClickListener {
            ActivityNavigate.navController.navigate(R.id.action_navFirstFragment_to_navSecondFragment)
        }
        binding.frgtPss.setOnClickListener {
            ActivityNavigate.navController.navigate(R.id.action_navFirstFragment_to_forgotpasswordFragment)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavFirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavFirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}