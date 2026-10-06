package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerTextView = findViewById<TextView>(R.id.registerTextView)
        val helpTextView = findViewById<TextView>(R.id.helpTextView)

        val registeredEmail = intent.getStringExtra(EXTRA_EMAIL)
        if (registeredEmail != null) {
            emailEditText.setText(registeredEmail)
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        registerTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        helpTextView.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(HELP_URL)))
        }
    }

    companion object {
        const val EXTRA_EMAIL = "EMAIL"
        private const val HELP_URL = "https://www.strathmore.edu"
    }
}
