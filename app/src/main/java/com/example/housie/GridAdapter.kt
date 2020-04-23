package com.example.housie

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_child_layout.view.*

class GridAdapter(val context: Context, private val userData: ArrayList<Int>) :
        RecyclerView.Adapter<GridAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_child, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userData[position])
        holder.itemView.setOnClickListener {
            if (userData[position] == 0) {
                return@setOnClickListener
            }

            holder.itemView.txt_number.setBackgroundColor(
                    context.resources.getColor(R.color.colorPrimaryDark))
            holder.itemView.txt_number.setTextColor(context.resources.getColor(R.color.white))
            //holder.itemView.txt_number.background = context.resources.getDrawable(R.drawable.cross_btn)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Int) {
            val txt_number = itemView.findViewById(R.id.txt_number) as TextView

            when (user) {
                0 -> txt_number.text = "     "
                1, 2, 3, 4, 5, 6, 7, 8, 9 -> txt_number.text = " $user "
                else -> txt_number.text = user.toString()
            }
        }
    }
}