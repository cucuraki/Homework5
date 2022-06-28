package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5.databinding.ActivityMainBinding
import com.example.homework5.databinding.ActivityRegister2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.register.setOnClickListener{
            toRegisterLayout()
        }
        binding.signIn.setOnClickListener{
            toSignInLayput()
        }
    }
    private fun toRegisterLayout(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
    private fun toSignInLayput(){
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }
}