package com.example.green_space_audits.mainactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {

    internal var registerBtn: Button? = null
    internal var loginBtn: Button? = null
    internal var Splash_time = 4000L
    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pref = getSharedPreferences("adminKey", Context.MODE_PRIVATE)
        if (pref.all.isNotEmpty()) {
            val enter = Intent(this@MainActivity, MapsActivity::class.java)
            startActivity(enter)
            overridePendingTransition(0, 0)
        }
        setContentView(R.layout.activity_main)

//        Handler().postDelayed({
//            setContentView(R.layout.activity_main)
//            registerBtn = findViewById(R.id.register)
//            loginBtn = findViewById(R.id.login)
//
//
//            registerBtn!!.setOnClickListener {
//                val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
//                startActivity(intent)
//            }
//            loginBtn!!.setOnClickListener {
//                val what = Intent(this@MainActivity,LoginActivity::class.java)
//                startActivity(what)
//            }
//            finish()
//
//        },Splash_time)

        registerBtn = findViewById(R.id.register)
        loginBtn = findViewById(R.id.login)


        registerBtn!!.setOnClickListener {
            val editor = pref.edit()
            editor.clear().commit()
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        loginBtn!!.setOnClickListener {

            val editor = pref.edit()
            editor.clear().commit()
            val what = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(what)
            overridePendingTransition(0, 0)
        }
    }
}
