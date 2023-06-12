package com.example.searchbar.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbar.R

class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.id1)
    val textView: TextView = itemView.findViewById(R.id.id2)
    val textView2: TextView = itemView.findViewById(R.id.id3)

    fun bind(homeKelas: HomeKelas) {
        imageView.setImageResource(homeKelas.Img)
        textView.text = homeKelas.name
        textView2.text = homeKelas.price
    }
}