package com.example.homework5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goBack.setOnClickListener{
            onBackPressed()
        }
        binding.btnLogIn.setOnClickListener{
            logIn()
        }
    }
    private fun logIn(){
        val email = binding.userName.text.toString().trim{it <=' '}
        val password = binding.password.text.toString().trim{it <=' '}
        if(email.isEmpty()){
            myToast("Please enter email")
            return
        }
        if(password.isEmpty()){
            myToast("Please enter password")
            return
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(!it.isSuccessful){
                    myToast(it.exception.toString())
                }else{
                    val id = FirebaseAuth.getInstance().currentUser!!.uid.toString()
                    myToast("You are signed in, your id is $id")
                    FirebaseAuth.getInstance().signOut()
                }

            }
    }
    private fun myToast(text: String){
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}