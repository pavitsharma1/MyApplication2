package com.example.myapplication.bottomnavigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvcostumeradapterBinding

class RvCostumerAdapter (var costumerarray: ArrayList<CostumerData>, var bottomNavInterface: bottomNavInterface):
    RecyclerView.Adapter<RvCostumerAdapter.ViewHolder>()  {


    class ViewHolder(var binding2: RvcostumeradapterBinding ): RecyclerView.ViewHolder(binding2.root) {

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        var binding2 = RvcostumeradapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding2)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.binding2.tvCostName.setText(costumerarray[position].name)
        holder.binding2.tvCostCont.setText(costumerarray[position].contact.toString())
        holder.binding2.tvCostPin.setText(costumerarray[position].pincode.toString())
        holder.binding2.tvCostOV.setText(costumerarray[position].avgodrval.toString())
        holder.itemView.setOnClickListener {
            bottomNavInterface.update(position)}
        holder.itemView.setOnLongClickListener {
            bottomNavInterface.remove(position)
        return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return costumerarray.size

    }

}