package com.example.myapplication.bottomnavigation

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvstockadapterBinding

class RvStockAdapter(var stockarray: ArrayList<StockData>, var bottomNavInterface: bottomNavInterface):
    RecyclerView.Adapter<RvStockAdapter.ViewHolder>()  {


    class ViewHolder(var binding: RvstockadapterBinding ): RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
       var binding = RvstockadapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.binding.tvStockName.setText(stockarray[position].name)
        holder.binding.tvStockPrice.setText(stockarray[position].price.toString())
        holder.binding.tvStockQuantity.setText(stockarray[position].quantity.toString())
        holder.itemView.setOnClickListener {

            bottomNavInterface.update(position)
        }
        holder.itemView.setOnLongClickListener {
            bottomNavInterface.remove(position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
       return stockarray.size

    }

}