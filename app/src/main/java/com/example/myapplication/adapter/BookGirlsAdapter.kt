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
import com.example.myapplication.model.Girls

class BookGirlsAdapter(var girls_books: ArrayList<Girls>):RecyclerView.Adapter<BookGirlsAdapter.MyHolder>(){
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var bookName : TextView = itemView.findViewById(R.id.book_girls_name)
        var img : ImageView = itemView.findViewById(R.id.book_girl_img)
        var cardView : CardView = itemView.findViewById(R.id.book_girl_bg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.girl_book,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return girls_books.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val index = girls_books[position]
        holder.bookName.text=index.name
        holder.img.load(index.img)
        holder.cardView.setCardBackgroundColor(index.bg_color)
    }


}