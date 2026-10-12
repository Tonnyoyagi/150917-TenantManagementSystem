package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "MainActivity: onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tenant = null

        if (savedInstanceState != null) {
            val name = savedInstanceState.getString(KEY_TENANT_NAME)
            val phone = savedInstanceState.getString(KEY_TENANT_PHONE)
            val rent = savedInstanceState.getString(KEY_TENANT_RENT)
            if (name != null && phone != null && rent != null) {
                val tenant = Tenant(name, phone, rent)
                lastTenant = tenant
                binding.tenant = tenant
            }
        }

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            if (name.isBlank() || phone.isBlank() || rent.isBlank()) {
                Toast.makeText(this, "Please complete all tenant fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

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
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LIFECYCLE_TAG, "MainActivity: onSaveInstanceState")
        lastTenant?.let { tenant ->
            outState.putString(KEY_TENANT_NAME, tenant.name)
            outState.putString(KEY_TENANT_PHONE, tenant.phone)
            outState.putString(KEY_TENANT_RENT, tenant.rent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "MainActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECYCLE_TAG, "MainActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "MainActivity: onDestroy")
    }

    private companion object {
        const val LIFECYCLE_TAG = "TENANT_LIFECYCLE"
        const val KEY_TENANT_NAME = "tenant_name"
        const val KEY_TENANT_PHONE = "tenant_phone"
        const val KEY_TENANT_RENT = "tenant_rent"
    }
}
