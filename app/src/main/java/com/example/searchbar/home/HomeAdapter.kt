package com.example.searchbar.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbar.BeliFragment
import com.example.searchbar.R
import com.example.searchbar.cart.CartFragment

class HomeAdapter (private val Listmerk: List<HomeKelas>) :
    RecyclerView.Adapter<ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.data_recycler, parent, false)
        return ItemViewHolder(view)
    }

//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val cek = Listmerk[position]
//        holder.bind(cek)
//        holder.textView.text = cek.name
//        holder.textView2.text = cek.price
//        holder.imageView.setImageResource(cek.Img)
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, BeliFragment::class.java)
//
//            // Mengirim data tambahan lainnya sesuai kebutuhan
//            holder.itemView.context.startActivity(intent)
//        }
//    }

    override fun getItemCount(): Int {
        return Listmerk.size
    }

}