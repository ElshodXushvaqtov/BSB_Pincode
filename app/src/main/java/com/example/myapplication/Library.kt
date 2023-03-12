package com.example.myapplication

import android.annotation.SuppressLint
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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val boysBooks = ArrayList<Boys>()
        boysBooks.add(
            Boys(
                "Mafia",
                "https://www.clipartmax.com/png/middle/1-19280_little-boy-reading-a-book-clip-art-read-book-clipart.png",
                Color.parseColor("#C7D1B2")
            )
        )
        boysBooks.add(
            Boys(
                "Man",
                "https://www.clipartmax.com/png/middle/1-19280_little-boy-reading-a-book-clip-art-read-book-clipart.png",
                Color.parseColor("#CCC6D0")
            )
        )
        boysBooks.add(
            Boys(
                "The Dark",
                "https://www.clipartmax.com/png/middle/1-19280_little-boy-reading-a-book-clip-art-read-book-clipart.png",
                Color.parseColor("#B7C8DE")
            )
        )
        boysBooks.add(
            Boys(
                "Black",
                "https://www.clipartmax.com/png/middle/1-19280_little-boy-reading-a-book-clip-art-read-book-clipart.png",
                Color.parseColor("#DCFAE5")
            )
        )
        boysBooks.add(
            Boys(
                "The Scream",
                "https://www.clipartmax.com/png/middle/1-19280_little-boy-reading-a-book-clip-art-read-book-clipart.png",
                Color.parseColor("#E1CAB3")
            )
        )
        val adapter = BookBoysAdapter(this,boysBooks)
        binding.boysRv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.boysRv.adapter = adapter

        val girlsBooks = ArrayList<Girls>()
        girlsBooks.add(
            Girls(
                "Princess",
                "https://www.clipartmax.com/png/middle/20-208179_cartoon-image-of-book-read-book-clipart.png",
                Color.parseColor("#E1B0E3")
            )
        )
        girlsBooks.add(
            Girls(
                "Dark Paradise",
                "https://www.clipartmax.com/png/middle/20-208179_cartoon-image-of-book-read-book-clipart.png",
                Color.parseColor("#BB93E3")
            )
        )
        girlsBooks.add(
            Girls(
                "Cinderella",
                "https://www.clipartmax.com/png/middle/20-208179_cartoon-image-of-book-read-book-clipart.png",
                Color.parseColor("#87CDE4")
            )
        )
        girlsBooks.add(
            Girls(
                "Mother",
                "https://www.clipartmax.com/png/middle/20-208179_cartoon-image-of-book-read-book-clipart.png",
                Color.parseColor("#788DE0")
            )
        )
        girlsBooks.add(
            Girls(
                "Beautiful",
                "https://www.clipartmax.com/png/middle/20-208179_cartoon-image-of-book-read-book-clipart.png",
                Color.parseColor("#B290D6")
            )
        )
        val adapter2 = BookGirlsAdapter(this,girlsBooks)
        binding.girlsRv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.girlsRv.adapter = adapter2
        val username=intent.getStringExtra("username")
        binding.userName.text="Welcome back, $username!\nHow are you?"
    }
}