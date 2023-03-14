package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Book

class CartAdapter(var cart_items: ArrayList<Book>) : RecyclerView.Adapter<CartAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_name: TextView = itemView.findViewById(R.id.cart_item_name)
        val item_type: TextView = itemView.findViewById(R.id.cart_item_type)
        val item_cart: CardView = itemView.findViewById(R.id.cart_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val index = cart_items[position]

    }

    override fun getItemCount(): Int {
        return cart_items.size
    }

}