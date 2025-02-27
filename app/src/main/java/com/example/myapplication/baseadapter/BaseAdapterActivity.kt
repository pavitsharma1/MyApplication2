package com.example.myapplication.baseadapter

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.content.DialogInterface
import android.text.Editable

import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.R.layout.dialog_list
import com.example.myapplication.databinding.ActivityBaseAdapterBinding

class BaseAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityBaseAdapterBinding
    lateinit var BaseAdapterView: BaseAdapterView
    var basearray=arrayListOf<ArrayData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityBaseAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        basearray.add(ArrayData(name="pavit",contact=1234567890,rollno=12345))
        BaseAdapterView= BaseAdapterView(basearray)
        binding.lvList1.adapter=BaseAdapterView
        binding.btnFlt2.setOnClickListener {
          var dialog= Dialog(this)
            dialog.setContentView(R.layout.dialog_list)
            dialog.show()
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
            var inputN = dialog.findViewById<EditText>(R.id.etDataName)
       var inputC = dialog.findViewById<EditText>(R.id.etDataCont)
       var inputR = dialog.findViewById<EditText>(R.id.etDataRlNo)
       var add=dialog.findViewById<Button>(R.id.btnAddData)
         add.setOnClickListener {
             if(inputN.text.toString().isEmpty() ||
                 inputC.text.toString().isEmpty() || inputR.text.toString().isEmpty()) {
                 Toast.makeText(this,"invalid input",Toast.LENGTH_SHORT).show()
              }
                 else{
                 basearray.add(ArrayData(name=inputN.text.toString(), contact=inputC.text.toString().toLong(), rollno = inputR.text.toString().toInt()))
                 BaseAdapterView.notifyDataSetChanged()
                 dialog.dismiss()
                 }
             }
        }
        binding.lvList1.setOnItemClickListener{adapterView,view,i,l->
            var dialog2=Dialog(this)
            dialog2.setContentView(R.layout.dialog_list2)
            dialog2.show()
            dialog2.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

            var inputN2 = dialog2.findViewById<EditText>(R.id.etDataName2)
            var inputC2 = dialog2.findViewById<EditText>(R.id.etDataCont2)
            var inputR2 = dialog2.findViewById<EditText>(R.id.etDataRlNo2)
            var add=dialog2.findViewById<Button>(R.id.btnAddData2)
            inputN2.setText(basearray[i].name.toString())
            inputC2.setText(basearray[i].contact.toString())
            inputR2.setText(basearray[i].rollno.toString())
            add.setOnClickListener {

                if(inputN2.text.toString().isEmpty() ||
                    inputC2.text.toString().isEmpty() || inputR2.text.toString().isEmpty()) {
                    Toast.makeText(this,"invalid input",Toast.LENGTH_SHORT).show()
                }
                else{
                        basearray[i]=(ArrayData(name=inputN2.text.toString(), contact=inputC2.text.toString().toLong(),
                            rollno = inputR2.text.toString().toInt()))
                        BaseAdapterView.notifyDataSetChanged()
                        dialog2.dismiss() }

            }
        }
        binding.lvList1.setOnItemLongClickListener{ AdapterView,view,i,l->
            AlertDialog.Builder(this)
                .setTitle("You Have Selected Element ${basearray[i]}")
                .setMessage("Do You Want To Remove This Element")
                .setNeutralButton ("remove"){_,_->
                    basearray.removeAt(i)
                    BaseAdapterView.notifyDataSetChanged()
                }
                .setPositiveButton("Cancel removing") {_,_->

                }
                .show()

            return@setOnItemLongClickListener true
        }

    }

}

