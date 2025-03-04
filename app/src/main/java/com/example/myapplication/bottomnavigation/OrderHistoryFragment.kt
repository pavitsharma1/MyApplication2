package com.example.myapplication.bottomnavigation

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
import com.example.myapplication.databinding.DialogOrderhistoryBinding
import com.example.myapplication.databinding.FragmentOrderHistoryBinding

/**
 * A simple [androidx.fragment.app.Fragment] subclass.
 * Use the [OrderHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderHistoryFragment : Fragment(), bottomNavInterface {
    lateinit var binding: FragmentOrderHistoryBinding
    lateinit var bottomNavigationActivity: BottomNavigationActivity
    var orderarray = arrayListOf< OrderData>()
    lateinit var adapterorder : RvOdHistoryAdapter
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
        binding = FragmentOrderHistoryBinding.inflate(layoutInflater)
        orderarray.add(OrderData(itemname = "chips", odrquantity = 25, itemprice = 140))
        adapterorder = RvOdHistoryAdapter(orderarray,this)

        binding.rvOrder1.layoutManager = LinearLayoutManager(bottomNavigationActivity)
        binding.rvOrder1.adapter = adapterorder
        binding.btnFltOdr.setOnClickListener {
            var dialogaddodr = Dialog(bottomNavigationActivity)
            dialogaddodr.setContentView(R.layout.dialog_orderhistory)
            dialogaddodr.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
            dialogaddodr.show()
            var itemName = dialogaddodr.findViewById<EditText>(R.id.etOrderName)
            var quantity = dialogaddodr.findViewById<EditText>(R.id.etOrderQuantity)
            var price = dialogaddodr.findViewById<EditText>(R.id.etOrderPrice)
            var costumerdatadder = dialogaddodr.findViewById<Button>(R.id.btnOrder)
            costumerdatadder.setOnClickListener {
                if (itemName.text.toString().isEmpty() || quantity.text.toString()
                        .isEmpty() || price.text.toString().isEmpty()
                ) {
                    Toast.makeText(bottomNavigationActivity, "invalid input", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    orderarray.add(
                        OrderData(
                            itemname = itemName.text.toString(),
                            itemprice = quantity.text.toString().toInt(),
                            odrquantity = price.text.toString().toInt()
                        )
                    )
                    adapterorder.notifyDataSetChanged()
                    dialogaddodr.dismiss()
                }
            }
        }
        return binding.root

    }


    override fun update(position: Int) {

        var dialogupdate3 = Dialog(bottomNavigationActivity)
        var orderDialogBinding= DialogOrderhistoryBinding.inflate(layoutInflater)
        dialogupdate3.setContentView(orderDialogBinding.root)
        dialogupdate3.show()
        dialogupdate3.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        orderDialogBinding.btnOrder.setOnClickListener {
            orderarray.set(position,OrderData(itemname = orderDialogBinding.etOrderName.text.toString(),
                odrquantity = orderDialogBinding.etOrderQuantity.text.toString().toInt(),
                itemprice = orderDialogBinding.etOrderPrice.text.toString().toInt()
                )
            )
            adapterorder.notifyDataSetChanged()
            dialogupdate3.dismiss()
        }    }

    override fun remove(position: Int) {

    }
}
