package com.example.aplikasisederhana

import android.content.Intent // Wajib di-import [11]
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegis: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUser = findViewById(R.id.etUsername)
        etPass = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegis = findViewById(R.id.btnGoToRegister)

        btnLogin.setOnClickListener {
            val username = etUser.text.toString().trim()
            val password = etPass.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username) // Mengirim data username [9, 12]
                startActivity(intent)
            }
        }

        btnRegis.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java)) // Pindah ke Regis [13]
        }
    }
}