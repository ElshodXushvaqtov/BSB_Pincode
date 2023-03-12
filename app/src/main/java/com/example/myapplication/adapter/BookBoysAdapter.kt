package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R
import com.example.myapplication.model.Boys

class BookBoysAdapter(var boys_books: ArrayList<Boys>): RecyclerView.Adapter<BookBoysAdapter.MyHolder>() {

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var item_name = itemView.findViewById<TextView>(R.id.book_boys_name)
        var img = itemView.findViewById<ImageView>(R.id.book_boy_img)
        var cardView = itemView.findViewById<CardView>(R.id.book_boy_bg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.boy_book, parent, false)
        )
    }

    override fun getItemCount(): Int {
return boys_books.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val index=boys_books[position]
        holder.item_name.text=index.name
        holder.img.load(index.img)
        holder.cardView.setCardBackgroundColor(index.bg_color)
    }

}