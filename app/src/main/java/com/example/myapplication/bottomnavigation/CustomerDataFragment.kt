package com.example.myapplication.bottomnavigation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCustomerDataBinding

/**
 * A simple [androidx.fragment.app.Fragment] subclass.
 * Use the [CustomerDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomerDataFragment : Fragment(), bottomNavInterface {
     lateinit var binding: FragmentCustomerDataBinding
     lateinit var bottomNavigationActivity: BottomNavigationActivity
    lateinit var adaptercostumer: RvCostumerAdapter
    var costumerarray = arrayListOf<CostumerData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationActivity=activity as BottomNavigationActivity
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentCustomerDataBinding.inflate(layoutInflater)
        costumerarray.add(CostumerData(name="chips", contact = 25, pincode = 145001, avgodrval = 10000))
        adaptercostumer = RvCostumerAdapter(costumerarray,this)
        binding.rvCostumer1.layoutManager = LinearLayoutManager(bottomNavigationActivity)
        binding.rvCostumer1.adapter=adaptercostumer
        binding.btnFltCost.setOnClickListener {
           var dialogaddcostumer= Dialog(bottomNavigationActivity)
            dialogaddcostumer.setContentView(R.layout.dialog_costumer)
            dialogaddcostumer.show()
            dialogaddcostumer.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

            var  customerName= dialogaddcostumer.findViewById<EditText>(R.id.etCostNameDialog)
            var costcont= dialogaddcostumer.findViewById<EditText>(R.id.etCostContDialog)
            var costpin= dialogaddcostumer.findViewById<EditText>(R.id.etCostPinDialog)
            var costval= dialogaddcostumer.findViewById<EditText>(R.id.etCostOvDialog)
            var costumerdatadder = dialogaddcostumer.findViewById<Button>(R.id.btnCostAdd)
            costumerdatadder.setOnClickListener {
                if (customerName.text.toString().isEmpty() || costcont.text.toString().isEmpty() || costpin.text.toString().isEmpty() ||
                    costval.text.toString().isEmpty()
                ) {
                    Toast.makeText(bottomNavigationActivity, "invalid input", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    costumerarray.add(
                        CostumerData(
                            name = customerName.text.toString(),
                            contact = costcont.text.toString().toLong(),
                            pincode = costpin.text.toString().toInt(),
                            avgodrval = costval.text.toString().toInt()
                        )
                    )
                    adaptercostumer.notifyDataSetChanged()
                    dialogaddcostumer.dismiss()
                }
            }

        }
        return binding.root

    }

    override fun update(position: Int) {
       var dialogupdate = Dialog(bottomNavigationActivity)
        dialogupdate.setContentView(R.layout.dialog_costumer)
        dialogupdate.show()
        dialogupdate.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

        var  customerName= dialogupdate.findViewById<EditText>(R.id.etCostNameDialog)
        var costcont= dialogupdate.findViewById<EditText>(R.id.etCostContDialog)
        var costpin= dialogupdate.findViewById<EditText>(R.id.etCostPinDialog)
        var costval= dialogupdate.findViewById<EditText>(R.id.etCostOvDialog)
        var costumerdatadder = dialogupdate.findViewById<Button>(R.id.btnCostAdd)
        costumerdatadder.setOnClickListener {
        costumerarray.set(position , CostumerData(name = customerName.text.toString(),
            pincode =costpin.text.toString().toInt(),
            contact = costcont.text.toString().toLong(),
            avgodrval = costval.text.toString().toInt()
            )
        )
            adaptercostumer.notifyDataSetChanged()
            dialogupdate.dismiss()
        }
    }

    override fun remove(position: Int) {
        AlertDialog.Builder(bottomNavigationActivity)
            .setTitle("Remover Dialog")
            .setNeutralButton ("remove"){_,_->
                costumerarray.removeAt(position)
                adaptercostumer.notifyDataSetChanged()
            }
            .setPositiveButton("Cancel removing") {_,_->

            }
            .show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomerDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomerDataFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}