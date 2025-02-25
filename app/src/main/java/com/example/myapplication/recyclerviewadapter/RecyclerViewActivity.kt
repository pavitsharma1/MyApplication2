package com.example.myapplication.recyclerviewadapter

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.baseadapter.ArrayData
import com.example.myapplication.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity(), RvInterface {
    lateinit var binding: ActivityRecyclerViewBinding
    lateinit var adapterView1: RvAdapter
    var rvarray=arrayListOf<ArrayData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvarray.add(ArrayData(name = "pavit", contact = 123456789, rollno = 12))
        adapterView1= RvAdapter(rvarray,this)
        binding.rcView1.layoutManager = LinearLayoutManager(this)
        binding.rcView1.adapter=adapterView1
        binding.rvAdd.setOnClickListener {
          singleDialog()
        }

    }

    fun singleDialog(position: Int = -1){
        var dialog1=Dialog(this)
        dialog1.setContentView(R.layout.dialog_list)
        dialog1.show()
        var inputn= dialog1.findViewById<TextView>(R.id.etDataName)
        var inputc = dialog1.findViewById<TextView>(R.id.etDataCont)
        var inputr=dialog1.findViewById<TextView>(R.id.etDataRlNo)
        var adder1=dialog1.findViewById<Button>(R.id.btnAddData)
        adder1.setOnClickListener {

            if (inputn.text.toString().isEmpty()){
                inputn.error="no inputs given"
            }
            else if (inputc.text.toString().isEmpty()){
                inputc.error="no inputs given"
            }
            else if (inputr.text.toString().isEmpty()){
                inputr.error="no inputs given"
            }
            else{
                if(position <= -1) {


                    rvarray.add(
                        ArrayData(
                            name = inputn.text.toString(),
                            contact = inputc.text.toString().toLong(),
                            rollno = inputr.text.toString().toInt()
                        )
                    )
                    adapterView1.notifyDataSetChanged()
                    dialog1.dismiss()
                }else{
                    rvarray.set(position,  ArrayData(
                        name = inputn.text.toString(),
                        contact = inputc.text.toString().toLong(),
                        rollno = inputr.text.toString().toInt()
                    ))
                    adapterView1.notifyDataSetChanged()
                    dialog1.dismiss()
                }
            }
        }
    }

    override fun addtext1(position: Int) {
       singleDialog(position)
    }

    override fun delete1(position: Int) {
        AlertDialog.Builder(this)
            .setTitle("Remover Dialog")
            .setNeutralButton ("remove"){_,_->
                rvarray.removeAt(position)
                adapterView1.notifyDataSetChanged()
            }
            .setPositiveButton("Cancel removing") {_,_->

            }
            .show()
    }
}