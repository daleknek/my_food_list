package com.athtech.myfoodlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter (private val data: List<Data>) : RecyclerView.Adapter<RecyclerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent,false)
        return RecyclerHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}