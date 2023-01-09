package com.athtech.myfoodlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(data: Data) {

        val title = view.findViewById<TextView>(R.id.title)
        val image = view.findViewById<ImageView>(R.id.image)
        val description = view.findViewById<TextView>(R.id.description)

        title.text = data.label
        description.text = data.ingredientLines.toString()
        Glide.with(view.context).load(data.image).centerCrop().into(image)

    }
}