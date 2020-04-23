package com.example.housie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_child_layout.view.*

class RecyclerMainAdapter(val context: Context, val list: ArrayList<Int>, var result: Int) :
        RecyclerView.Adapter<RecyclerMainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.main_child_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.number.text = list[position].toString()
        if (list.contains(result) && (result - 1) == position) {
            holder.itemView.setBackgroundColor(context.resources.getColor(R.color.colorPrimary))
        }
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var number: TextView = v.txt_number
    }

    fun sample(arrayList: Int) {
        result = arrayList
        notifyItemChanged(arrayList - 1)
    }
}