package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLogInBinding
import com.example.myapplication.model.User

var users = ArrayList<User>()

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        if (intent != null) {
            users =
                getIntent().getSerializableExtra("users") as ArrayList<User>
        }
        Log.d("NMN", users.toString())

        binding.next.setOnClickListener {
            if (check()) {
                val intent = Intent(this, PinCodeActivity::class.java)
                intent.putExtra("username", binding.username.text.toString())
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Please, check you info again!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    private fun check(): Boolean {
        for (i in users.indices) {
            if (binding.username.text.toString() == users[i].name && binding.password.text.toString() == users[i].password) {
                Toast.makeText(applicationContext, "Welcome, ${users[i].name}!", Toast.LENGTH_LONG)
                    .show()
                return true
            }
        }
        return false
    }
}