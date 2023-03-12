package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityPinCodeBinding
import com.example.myapplication.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PinCodeActivity : AppCompatActivity() {
    private var pinList = mutableListOf<User>()
    private lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = intent.getStringExtra("userName").toString()
        val binding = ActivityPinCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type

        binding.verifyCreateBtn.setOnClickListener {
            Toast.makeText(applicationContext,"PIN code saved succesfully!",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Library::class.java)
            intent.putExtra("name", username)
            startActivity(intent)
            finish()
        }

    }

}

