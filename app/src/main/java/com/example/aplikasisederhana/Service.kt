package com.example.aplikasisederhana

data class Service(
    val id: Int,
    val type: String,      // Contoh: Service TV, Laptop
    val description: String, // Deskripsi singkat kerusakan
    val technician: String,
    val estimatedPrice: Int
) {
    fun getFormattedPrice(): String = "Estimasi: Rp ${estimatedPrice}"
}
