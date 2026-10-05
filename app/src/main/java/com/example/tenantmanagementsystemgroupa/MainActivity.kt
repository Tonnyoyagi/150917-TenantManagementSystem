package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra(LoginActivity.EXTRA_EMAIL)?.let { email ->
            Toast.makeText(this, "Logged in as $email", Toast.LENGTH_LONG).show()
        }

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            binding.tenantNameEditText.error = if (name.isBlank()) "Required" else null
            binding.phoneEditText.error = if (phone.isBlank()) "Required" else null
            binding.rentEditText.error = if (rent.isBlank()) "Required" else null
            if (name.isBlank() || phone.isBlank() || rent.isBlank()) return@setOnClickListener

            val tenant = Tenant(name, phone, rent)
            lastTenant = tenant
            binding.tenant = tenant
        }

        binding.callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}")))
        }

        binding.shareButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val shareIntent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, tenant.summary())
            startActivity(Intent.createChooser(shareIntent, "Share tenant"))
        }
    }
}
