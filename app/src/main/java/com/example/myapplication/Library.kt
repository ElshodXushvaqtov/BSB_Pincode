package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.BookBoysAdapter
import com.example.myapplication.adapter.BookGirlsAdapter
import com.example.myapplication.databinding.ActivityLibraryBinding
import com.example.myapplication.model.Boys
import com.example.myapplication.model.Girls

class Library : AppCompatActivity() {
    lateinit var binding: ActivityLibraryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val boysBooks = ArrayList<Boys>()
        boysBooks.add(
            Boys(
                "Mafia",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1186125868i/1632138.jpg",
                Color.parseColor("#C7D1B2")
            )
        )
        boysBooks.add(
            Boys(
                "Man",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1186125868i/1632138.jpg",
                Color.parseColor("#CCC6D0")
            )
        )
        boysBooks.add(
            Boys(
                "The Dark",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1186125868i/1632138.jpg",
                Color.parseColor("#B7C8DE")
            )
        )
        boysBooks.add(
            Boys(
                "Black",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1186125868i/1632138.jpg",
                Color.parseColor("#DCFAE5")
            )
        )
        boysBooks.add(
            Boys(
                "The Scream",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1186125868i/1632138.jpg",
                Color.parseColor("#E1CAB3")
            )
        )
        val adapter = BookBoysAdapter(boysBooks)
        binding.boysRv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.boysRv.adapter = adapter

        val girlsBooks = ArrayList<Girls>()
        girlsBooks.add(
            Girls(
                "Princess",
                "https://igromaster.by/upload/iblock/6d1/6d1355e4cfa7c12744c10108a7309084.jpg",
                Color.parseColor("#E1B0E3")
            )
        )
        girlsBooks.add(
            Girls(
                "Dark Paradise",
                "https://igromaster.by/upload/iblock/6d1/6d1355e4cfa7c12744c10108a7309084.jpg",
                Color.parseColor("#BB93E3")
            )
        )
        girlsBooks.add(
            Girls(
                "Cinderella",
                "https://igromaster.by/upload/iblock/6d1/6d1355e4cfa7c12744c10108a7309084.jpg",
                Color.parseColor("#87CDE4")
            )
        )
        girlsBooks.add(
            Girls(
                "Mother",
                "https://igromaster.by/upload/iblock/6d1/6d1355e4cfa7c12744c10108a7309084.jpg",
                Color.parseColor("#788DE0")
            )
        )
        girlsBooks.add(
            Girls(
                "Beautiful",
                "https://igromaster.by/upload/iblock/6d1/6d1355e4cfa7c12744c10108a7309084.jpg",
                Color.parseColor("#B290D6")
            )
        )
        val adapter2 = BookGirlsAdapter(girlsBooks)
        binding.girlsRv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.girlsRv.adapter = adapter2
        val username=intent.getStringExtra("name")
        binding.userName.text="Welcome back, $username!\nHow are you?"
    }
}