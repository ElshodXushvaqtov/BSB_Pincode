package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.next.setOnClickListener {
            if (binding.username.text.toString() == "") {
                Toast.makeText(applicationContext, "Please enter UserName", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent=Intent(this,PinCodeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}