package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tenantNameEditText = findViewById<EditText>(R.id.tenantNameEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val rentEditText = findViewById<EditText>(R.id.rentEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val callButton = findViewById<Button>(R.id.callButton)
        val tenantResultTextView = findViewById<TextView>(R.id.tenantResultTextView)

        saveButton.setOnClickListener {
            val name = tenantNameEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val rent = rentEditText.text.toString().trim()

            if (name.isBlank() || phone.isBlank() || rent.isBlank()) {
                Toast.makeText(this, "Please complete all tenant fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tenant = Tenant(name, phone, rent)
            lastTenant = tenant
            tenantResultTextView.text = tenant.summary()
        }

        callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}")))
        }
    }
}
