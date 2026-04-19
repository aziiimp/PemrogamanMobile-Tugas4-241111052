package com.example.aplikasisederhana

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ServiceListActivity : AppCompatActivity() {

    private val serviceList = listOf(
        Service(1, "Service LED TV",
            "Perbaikan layar bergaris/mati total", "Teknisi Agung", 350000),
        Service(2, "Service Laptop",
            "Instalasi ulang & ganti keyboard", "Teknisi Charli", 150000),
        Service(3, "Service AC",
            "Isi freon & ganti kompresor", "Teknisi Endo", 250000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_service)

        val rvServices = findViewById<RecyclerView>(R.id.rvServices)
        rvServices.layoutManager = LinearLayoutManager(this)

        // Memasang Adapter
        val adapter = ServiceAdapter(serviceList) { service ->
            // Feedback berupa Toast saat item diklik
            Toast.makeText(this, "Detail Service: ${service.type} - ${service.technician}", Toast.LENGTH_SHORT).show()
        }
        rvServices.adapter = adapter

        // Inisialisasi Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Set menu item "Service" sebagai aktif (selected)
        bottomNav.selectedItemId = R.id.nav_service

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Pindah ke HomeActivity menggunakan Intent Eksplisit [1, 17, 18]
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_service -> {
                    // Sudah di halaman Service
                    true
                }
                else -> false
            }
        }
    }
}