package com.example.database16

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference//this variable is use ton refer to data base
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val signButton = findViewById<Button>(R.id.button)
        val etname =findViewById<TextInputEditText>(R.id.etname)
        val etgmail =findViewById<TextInputEditText>(R.id.etmail)
        val etpassword =findViewById<TextInputEditText>(R.id.etpassword)
        val etid =findViewById<TextInputEditText>(R.id.etid)


        signButton.setOnClickListener {

            val name = etname.text.toString()
            val mail= etgmail.text.toString()
            val password=etpassword.text.toString()
            val id= etid.text.toString()

            val user = user(name,mail, password, id)//this parameter refers to another file ->user.kt

            database=FirebaseDatabase.getInstance().getReference("user")
            database.child(id).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                Toast.makeText(this,"User Registerd",Toast.LENGTH_SHORT).show()
            }

        }


        val signText=findViewById<TextView>(R.id.signIntext)
        signText.setOnClickListener {
            val openSignActivity = Intent(this, signInActivity::class.java)
            startActivity(openSignActivity)
        }
    }

    
}