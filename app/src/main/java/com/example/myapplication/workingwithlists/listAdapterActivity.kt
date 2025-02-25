package com.example.myapplication.workingwithlists

import android.app.AlertDialog
import android.os.Bundle
import android.content.DialogInterface
import android.widget.ArrayAdapter
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import android.app.Dialog
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar.LayoutParams
import com.example.myapplication.databinding.ActivityListAdapterBinding

class listAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityListAdapterBinding
    lateinit var arrayAdapter: ArrayAdapter<String>
    var x = "hello"
    var thisarray=arrayListOf<String>("a","b","c","d","e","f","g","h","i")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityListAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,thisarray)
        binding.lvList.adapter=arrayAdapter
        binding.fltBtn.setOnClickListener {
           var dialog =Dialog(this)
            dialog.setContentView(R.layout.dialog_list)
            dialog.show()
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

            var newdata=dialog.findViewById<EditText>(R.id.etDataName)
           var savedata=dialog.findViewById<Button>(R.id.btnAddData)
            savedata.setOnClickListener {
                thisarray.add(newdata.text.toString())
                arrayAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
         binding.lvList.setOnItemClickListener{adapterView,view,i,l->
             var dialog2 =Dialog(this)
             dialog2.setContentView(R.layout.dialog_list2)
             dialog2.show()
             dialog2.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

             var newdata2=dialog2.findViewById<EditText>(R.id.etDataName2)
             var savedata2=dialog2.findViewById<Button>(R.id.btnAddData2)
             savedata2.setOnClickListener {
                 thisarray[i]=newdata2.text.toString()
                 arrayAdapter.notifyDataSetChanged()
                 dialog2.dismiss()
             }
         }
        binding.lvList.setOnItemLongClickListener{adapterView,view,i,l->
            AlertDialog.Builder(this)
                .setTitle("You Have Selected Element ${thisarray[i]}")
                .setMessage("Do You Want To Remove This Element")
                .setNeutralButton ("remove"){_,_->
                    thisarray.removeAt(i)
                    arrayAdapter.notifyDataSetChanged()
                }
                .setPositiveButton("Cancel removing") {_,_->

                }
                .show()
            return@setOnItemLongClickListener true

        }

    }
}