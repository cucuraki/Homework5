package com.example.homework5

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityRegister2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class RegisterActivity2: AppCompatActivity() {
    private lateinit var binding: ActivityRegister2Binding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.termsAndConditions.movementMethod = LinkMovementMethod.getInstance()
        binding.goBack.setOnClickListener{
            onBackPressed()
        }
        binding.btnRegister.setOnClickListener {
            register()
        }
    }
    private fun register(){
        if(binding.name.text.toString().trim{it<=' '}.isEmpty()){
            myToast("Please enter your name")
            return
        }
        val email = intent.getStringExtra("email").toString()
        val password = intent.getStringExtra("password").toString()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    val user: FirebaseUser = it!!.result!!.user!!
                    myToast("You are registered")
                    FirebaseAuth.getInstance().signOut()
                }else{
                    myToast(it.exception!!.message.toString())
                }
            }
    }
    private fun myToast(text: String){
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}