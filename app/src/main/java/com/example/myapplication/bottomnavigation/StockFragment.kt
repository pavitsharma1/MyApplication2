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
import com.example.myapplication.databinding.DialogCostumerBinding
import com.example.myapplication.databinding.DialogStockBinding
import com.example.myapplication.databinding.FragmentStockBinding
import com.example.myapplication.recyclerviewadapter.RvAdapter
import com.example.myapplication.recyclerviewadapter.RvInterface

class StockFragment : Fragment(), bottomNavInterface {
    lateinit var binding: FragmentStockBinding
    lateinit var bottomNavigationActivity: BottomNavigationActivity
    lateinit var adapterstock: RvStockAdapter
    var stockarray = arrayListOf<StockData>()
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
        binding= FragmentStockBinding.inflate(layoutInflater)
        stockarray.add(StockData(name="chips", price = 25, quantity = 100))
        adapterstock= RvStockAdapter(stockarray, this)
        binding.rvStock1.layoutManager = LinearLayoutManager(bottomNavigationActivity)
        binding.rvStock1.adapter=adapterstock
        binding.btnStockAdd.setOnClickListener {
            var stockdialog = Dialog(bottomNavigationActivity)
            stockdialog.setContentView(R.layout.dialog_stock)
            stockdialog.show()
            stockdialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

            var name1=stockdialog.findViewById<EditText>(R.id.tvStockName2)
            var price1=stockdialog.findViewById<EditText>(R.id.tvStockPrice2)
            var quantity1=stockdialog.findViewById<EditText>(R.id.tvStockQuantity2)
            var stockadd=stockdialog.findViewById<Button>(R.id.btnStockAdd2)
            stockadd.setOnClickListener {
                if (name1.text.toString().isEmpty() ||
                    price1.text.toString().isEmpty()||
                    quantity1.text.toString().isEmpty()
                    ){
                    Toast.makeText(bottomNavigationActivity,"invalid input", Toast.LENGTH_SHORT).show()
                }
                else(
                    stockarray.add(StockData(name=name1.text.toString(), price = price1.text.toString().toInt(),
                        quantity = quantity1.text.toString().toInt()))
                )
                    adapterstock.notifyDataSetChanged()
                stockdialog.dismiss()
            }
        }
        return binding.root
    }

    override fun update(position: Int) {

        var dialogupdate2 = Dialog(bottomNavigationActivity)
        var dialogBinding = DialogStockBinding.inflate(layoutInflater)
        dialogupdate2.setContentView(dialogBinding.root)
        dialogupdate2.show()
        dialogupdate2.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

        dialogBinding.btnStockAdd2.setOnClickListener {
            stockarray.set(position , StockData(name = dialogBinding.tvStockName2.text.toString(),
                 price=dialogBinding.tvStockPrice2.text.toString().toInt(),
                quantity = dialogBinding.tvStockQuantity2.text.toString().toInt()
            )
            )
            adapterstock.notifyDataSetChanged()
            dialogupdate2.dismiss()
        }
    }

    override fun remove(position: Int) {
        AlertDialog.Builder(bottomNavigationActivity)
            .setTitle("Remover Dialog")
            .setNeutralButton ("remove"){_,_->
                stockarray.removeAt(position)
                adapterstock.notifyDataSetChanged()
            }
            .setPositiveButton("Cancel removing") {_,_->

            }
            .show()
    }

    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment StockFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            StockFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
    }
}