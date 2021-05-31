package com.example.studyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar

class Register : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var email : EditText
    private lateinit var mNumber : EditText
    private lateinit var signUp : Button
    private lateinit var db : DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        username = findViewById(R.id.username_register_id)
        password = findViewById(R.id.password_register_id)
        email = findViewById(R.id.email_register_id)
        mNumber = findViewById(R.id.phone_register_id)
        signUp = findViewById(R.id.sign_up_id)
        db = DatabaseHelper(this)

        signUp.setOnClickListener {
            val userName = username.text.toString().trim()
            val passWord = password.text.toString().trim()
            val emailTemp = email.text.toString().trim()
            val number = mNumber.text.toString().trim()

            if(userName == "" || passWord == "" || emailTemp == "" || number == "")
            {
                Toast.makeText(this,"All Fields are required",Toast.LENGTH_SHORT).show()
            }
            else
            {
                if(!db.checkCredentialsForRegistration(userName))
                {
                    val status = db.insertData(userName,passWord,emailTemp,number)
                    if(status)
                    {
                        SaveSharedPreference.setUsername(this,userName)
                        Toast.makeText(this,"Registration Successful",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Dashboard::class.java)
                        intent.putExtra("Username",userName)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,"Registration failed",Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this,"Username already exist",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            android.R.id.home -> {finish()
                return true}
            else -> {false}
        }
    }
}