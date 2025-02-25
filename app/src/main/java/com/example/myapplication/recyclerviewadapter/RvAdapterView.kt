package com.example.myapplication.recyclerviewadapter

import android.app.AlertDialog
import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.baseadapter.ArrayData
import com.example.myapplication.databinding.RvAdapterBinding

class RvAdapter(var rvarray: ArrayList<ArrayData>, var rvinterface: RvInterface):RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    class ViewHolder(var binding: RvAdapterBinding) : RecyclerView.ViewHolder(binding.root){
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RvAdapter.ViewHolder {
        var binding= RvAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
       holder.binding.rvName.setText(rvarray[position].name)
        holder.binding.rvRoll.setText(rvarray[position].rollno.toString())
        holder.binding.rvCont.setText(rvarray[position].contact.toString())
        holder.itemView.setOnClickListener {
            rvinterface.addtext1(position)
        }
        holder.itemView.setOnLongClickListener {
            rvinterface.delete1(position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
       return rvarray.size
    }

}