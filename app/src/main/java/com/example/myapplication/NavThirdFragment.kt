package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.FragmentNavThirdBinding
import com.example.myapplication.jetpacknavitagtion.JetPackActivity


class NavThirdFragment : Fragment() {
    lateinit var binding: FragmentNavThirdBinding
    var x = 0

    lateinit var jetPackActivity: JetPackActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jetPackActivity=activity as JetPackActivity
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNavThirdBinding.inflate(layoutInflater)

      binding.btnAlertDialog.setOnClickListener {
          AlertDialog.Builder(jetPackActivity)
              .setTitle("hello there")
              .show()
      }
        binding.btnDialog.setOnClickListener {
            var dialog = Dialog(jetPackActivity)
            dialog.setContentView(R.layout.fragment_login_screen)
            dialog.show()
            var add = dialog.findViewById<Button>(R.id.btnAdd)
            var sub = dialog.findViewById<Button>(R.id.btnSub)
            var zero = dialog.findViewById<Button>(R.id.btn0)
            add.setOnClickListener {
                binding.btnDialog.text= "${++x}"
                dialog.dismiss()
            }
//            binding.btnDialog.text=x.toString()
            sub.setOnClickListener {
                binding.btnDialog.text="${--x}"
            }
            zero.setOnClickListener {
                binding.btnDialog.text="0"
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
//         * @return A new instance of fragment NavThirdFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            NavThirdFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}