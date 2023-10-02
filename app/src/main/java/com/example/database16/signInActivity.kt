package com.example.database16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signInActivity : AppCompatActivity() {
    private lateinit var databaseReference:DatabaseReference
    //creating key
    companion object{
        const val  KEY1 = "com.example.database16.signInActivity.email"
        const val  KEY2 = "com.example.database16.signInActivity.name"
        const val  KEY3 = "com.example.database16.signInActivity.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signbutton=findViewById<Button>(R.id.buttonSignIn)
        val username=findViewById<TextInputEditText>(R.id.userNameEditText)

        signbutton.setOnClickListener {
            //take reference till node "User"
            val uniqId = username.text.toString()
            if(uniqId.isNotEmpty()){
                readData(uniqId)
            }else{
                Toast.makeText(this,"please enter user id",Toast.LENGTH_SHORT).show()
            }

        }
    }
    //On Create over

    private fun readData(uniqId: String) {
databaseReference=FirebaseDatabase.getInstance().getReference("User")

        databaseReference.child(uniqId).get().addOnSuccessListener {

            //if user exist or  not

            if (it.exists()){
                val email=it.child("email").value
                val name=it.child("name").value
                val id=it.child("id").value

                val intentWelcome=Intent(this,WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1,email.toString())
                intentWelcome.putExtra(KEY2,name.toString())
                intentWelcome.putExtra(KEY3,id.toString())
                startActivity(intentWelcome)


            }else{
                Toast.makeText(this,"user does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this,"Failed,Error in DB",Toast.LENGTH_SHORT).show()
        }


        }
    }
