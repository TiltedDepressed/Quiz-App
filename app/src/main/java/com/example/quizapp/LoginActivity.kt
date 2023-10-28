package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            login()
        }
        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login(){
        val email: String = binding.emailAddressEditText.text.toString().trim()
        val password : String = binding.passwordEditText.text.toString().trim()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }


        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else{
                    Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }

    }


}