package com.example.myapplication.baseadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.R

class BaseAdapterView(var data: ArrayList<ArrayData>) : BaseAdapter(){
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any? {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        p1: View?,
        parent: ViewGroup?,
    ): View? {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.list_view_activity,parent,false)
        var name = view.findViewById<TextView>(R.id.tvName)
        name.text = data[position].name
        var contact = view.findViewById<TextView>(R.id.tvCon)
        contact.text = data[position].contact.toString()
        var rollno = view.findViewById<TextView>(R.id.tvRlNo)
        rollno.text = data[position].rollno.toString()
      return view
    }
}