package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.goBack.setOnClickListener{
            onBackPressed()
        }
        binding.btnNext.setOnClickListener{
            goToNextPageOfRegistration()
        }
    }
    private fun goToNextPageOfRegistration(){
        val email = binding.userName
        val password = binding.password
        when{
            email.text.toString().trim{it<=' '}.isEmpty()->{
                myToast("Email should't be empty")
            }
            password.text.toString().trim{it<=' '}.length<6->{
                myToast("Password is to short")
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email
                .text.toString().trim{it <= ' '})
                .matches()->{
                    myToast("Please enter valid email")
                }
            else-> {
                val intent = Intent(this, RegisterActivity2::class.java)
                intent.putExtra("email", email.text.toString().trim{it<=' '})
                intent.putExtra("password", password.text.toString().trim{it<=' '})
                startActivity(intent)
            }
        }
    }
    private fun myToast(text: String){
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}