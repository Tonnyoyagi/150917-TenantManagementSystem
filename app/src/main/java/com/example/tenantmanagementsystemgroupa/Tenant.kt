package com.example.tenantmanagementsystemgroupa

import java.io.Serializable

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,
) : Serializable {
    fun summary(): String = "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
}
