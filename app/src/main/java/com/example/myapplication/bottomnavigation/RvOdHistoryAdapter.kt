package com.example.myapplication.bottomnavigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvodrhistoryadapterBinding

class RvOdHistoryAdapter (var orderarray: ArrayList<OrderData>, var bottomNavInterface: bottomNavInterface):
    RecyclerView.Adapter<RvOdHistoryAdapter.ViewHolder>()  {


    class ViewHolder(var binding: RvodrhistoryadapterBinding ): RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        var binding = RvodrhistoryadapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.binding.tvItemName.setText(orderarray[position].itemname)
        holder.binding.tvItemPrice.setText(orderarray[position].itemprice.toString())
        holder.binding.tvItemQuantity.setText(orderarray[position].odrquantity.toString())

        holder.itemView.setOnClickListener {
println("CHeck Value Data")
            //bottomNavInterface.update(position)
        }
//        holder.itemView.setOnLongClickListener {
//            bottomNavInterface.remove(position)
//            return@setOnLongClickListener true
//        }
    }

    override fun getItemCount(): Int {
        return orderarray.size

    }

}