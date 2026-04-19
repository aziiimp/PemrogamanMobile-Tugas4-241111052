package com.example.aplikasisederhana

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUserRegis: EditText
    private lateinit var etPassRegis: EditText
    private lateinit var etConfirmPass: EditText
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUserRegis = findViewById(R.id.etUserRegis)
        etPassRegis = findViewById(R.id.etPassRegis)
        etConfirmPass = findViewById(R.id.etConfirmPass)
        btnSimpan = findViewById(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val user = etUserRegis.text.toString().trim()
            val pass = etPassRegis.text.toString().trim()
            val confirm = etConfirmPass.text.toString().trim()

            // Validasi field kosong dan kecocokan password [9]
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Field tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else if (pass != confirm) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke halaman Login [10]
            }
        }
    }
}