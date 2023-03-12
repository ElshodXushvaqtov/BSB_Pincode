package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.security.auth.login.LoginException

private var userList = ArrayList<User>()
private var userNames = ArrayList<String>()

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type
        binding.next.setOnClickListener {
            if (binding.username.text.toString().isNotEmpty() && binding.passcode.text.toString()
                    .isNotEmpty()
            ) {
                val users = shared.getString("users", "")
                userList = if (users == "") {
                    ArrayList()
                } else {
                    gson.fromJson(users, convert)
                }
                if (check()) {
                    userList.add(
                        User(
                            binding.username.text.toString(),
                            binding.passcode.text.toString()
                        )
                    )
                    userNames.add(binding.username.text.toString())
                    val str = gson.toJson(userList)
                    edit.putString("users", str).apply()
                    Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LogInActivity::class.java)
                    intent.putExtra(
                        "users",
                        userList
                    )
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "This user is alredy registered", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this, LogInActivity::class.java)
                    intent.putExtra(
                        "users",
                        userList
                    )
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun check(): Boolean {
        for (i in userList.indices) {
            if (binding.username.text.toString() == userList[i].name) {
                Toast.makeText(this, "This user is alredy registered", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }
}