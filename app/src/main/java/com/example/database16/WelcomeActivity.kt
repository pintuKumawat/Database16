package com.example.database16

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val email = intent.getStringExtra(signInActivity.KEY1)
        val name = intent.getStringExtra(signInActivity.KEY2)
        val id = intent.getStringExtra(signInActivity.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tvWelcome1)
        val mailText=findViewById<TextView>(R.id.tvMail)
        val idText =findViewById<TextView>(R.id.tvUnique)
        welcomeText.text="Welcome $name"
        mailText.text="email $email"
        idText.text="id $id"





    }
}