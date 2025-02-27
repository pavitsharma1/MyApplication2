package com.example.myapplication.numberlistactivity
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ColorRvAdapterBinding
import kotlin.random.Random

class ColorRvAdapter ( var clrarray: ArrayList<Int>):RecyclerView.Adapter<ColorRvAdapter.ViewHolder>(){
    class ViewHolder(var binding: ColorRvAdapterBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ColorRvAdapter.ViewHolder {
        var binding= ColorRvAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ColorRvAdapter.ViewHolder,
        position: Int,
    ) {
       holder.binding.main.setBackgroundColor(Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))

    }

    override fun getItemCount(): Int {
        return clrarray.size
    }
}