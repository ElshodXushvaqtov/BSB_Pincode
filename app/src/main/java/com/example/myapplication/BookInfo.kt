package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.load
import com.example.myapplication.databinding.ActivityBookInfoBinding
import com.example.myapplication.model.Book
import com.example.myapplication.model.Boys
import com.example.myapplication.model.Girls

class BookInfo : AppCompatActivity() {
    lateinit var binding: ActivityBookInfoBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val type=intent.getBooleanExtra("bool",false)
        val book_boy=intent.getSerializableExtra("books") as ArrayList<Boys>
        val book_girl=intent.getSerializableExtra("books") as ArrayList<Girls>
        val index=intent.getIntExtra("index",0)
        if(type){
            binding.bookType.text="Boys"
            binding.bookImg.load(book_boy[index].img)
            binding.bookName.text=book_boy[index].name
            Log.d("BOY", book_boy[index].name)
        }
        else{
            binding.bookType.text="Girls"
            binding.bookImg.load(book_girl[index].img)
            binding.bookName.text=book_girl[index].name
            Log.d("GIRL", book_girl[index].name)
        }
binding.exitInfo.setOnClickListener {
    val intent=Intent(this,Library::class.java)
    startActivity(intent)
    finish()
}

binding.addCart.setOnClickListener {
    Toast.makeText(applicationContext,"Succesfully saved",Toast.LENGTH_SHORT).show()
}



    }
}