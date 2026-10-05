package com.example.tenantmanagementsystemgroupa

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,
) {
    fun summary(): String = "Tenant: $name\nPhone: $phone\nMonthly rent: $rent"
}
