package com.example.studyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.NavUtils

class LoginActivity : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var login : Button
    private lateinit var db : DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.username_login_id)
        password = findViewById(R.id.password_login_id)
        login = findViewById(R.id.sign_in_id)
        db = DatabaseHelper(this)
        login.setOnClickListener {
            val userText = username.text.toString().trim()
            val passText = password.text.toString().trim()
            if(userText == "" || passText == "")
            {
                Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show()
            }
            else
            {
                if(db.checkCredentialsForLogin(userText,passText))
                {
                    SaveSharedPreference.setUsername(this,userText)
                    Toast.makeText(this,"Sign in Successful",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,Dashboard::class.java)
                    intent.putExtra("Username",userText)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                }
            }
        } // login onclick listener ends
    } //onCreate method ends
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            android.R.id.home -> {finish()
                return true}
            else -> {false}
        }
    }
} // LoginActivity ends