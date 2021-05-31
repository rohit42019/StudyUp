package com.example.studyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(SaveSharedPreference.getUsername(this)?.length != 0 )
        {
            val intent = Intent(this,Dashboard::class.java)
            intent.putExtra("Username",SaveSharedPreference.getUsername(this))
            startActivity(intent)
        }
        else
        {
            //setting the custom action bar for Title Screen
            setContentView(R.layout.activity_main)

            val register = findViewById<Button>(R.id.register_id)
            val login = findViewById<Button>(R.id.login_id)

            register.setOnClickListener {
                val intent = Intent(this,Register::class.java)
                startActivity(intent)
            }
            login.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }
}