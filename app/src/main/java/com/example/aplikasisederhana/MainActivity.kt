package com.example.aplikasisederhana

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen TextView untuk menampilkan usernama
        tvWelcome = findViewById(R.id.tvWelcome)
        tvUsername = findViewById(R.id.tvUsernameDisplay)

        // Inisialisasi komponen TextView untuk menampilkan usernama
        // Mengambil data username yang dikirim dari LoginActivity melalui Intent
        // Pastikan key "username" sama dengan yang digunakan di putExtra pada LoginActivity
        val username = intent.getStringExtra("username")

        // Menampilkan data ke TextView
        // Menggunakan nilai default "-" jika data username kosong atau null
        tvUsername.text = "${username ?: "-"}"

        // 3. Navigasi Intent Eksplisit ke Daftar Service
        val cardService = findViewById<CardView>(R.id.cardServiceMenu)
        cardService.setOnClickListener {
            val intent = Intent(this, ServiceListActivity::class.java)
            startActivity(intent)
        }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> true // Sudah di halaman utama
                R.id.nav_service -> {
                    // Intent Eksplisit ke daftar data [2, 3]
                    startActivity(Intent(this, ServiceListActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Fitur Profil segera hadir", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}