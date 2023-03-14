package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

private var userList = ArrayList<User>()
private var userNames = ArrayList<String>()

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var spinner: Spinner
    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        currentLanguage = intent.getStringExtra(currentLang).toString()
        spinner = findViewById(R.id.spinner)
        val list = ArrayList<String>()
        list.add("Select Language")
        list.add("English")
        list.add("Russian")
        list.add("Uzbek")
        val adapter =
            ArrayAdapter(this, com.chaos.view.R.layout.support_simple_spinner_dropdown_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("ru")
                    3 -> setLocale("uz")
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            private fun setLocale(localeName: String) {
                if (localeName != currentLanguage) {
                    locale = Locale(localeName)
                    val res = resources
                    val dm = res.displayMetrics
                    val conf = res.configuration
                    conf.locale = locale
                    res.updateConfiguration(conf, dm)
                    val refresh = Intent(
                        this@MainActivity,
                        MainActivity::class.java
                    )
                    refresh.putExtra(currentLang, localeName)
                    startActivity(refresh)
                    finish()
                } else {
                    Toast.makeText(
                        this@MainActivity, "Language, , already, , selected)!", Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }

        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type

        binding.login.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            intent.putExtra(
                "users",
                userList
            )
            startActivity(intent)
            finish()
        }
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
                    val intent = Intent(this, PinCodeActivity::class.java)
                    intent.putExtra(
                        "users",
                        userList
                    )
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Please Login", Toast.LENGTH_SHORT)
                        .show()
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