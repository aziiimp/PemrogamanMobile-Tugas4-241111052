package com.example.aplikasisederhana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aplikasisederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Simpan username dari LoginActivity untuk diteruskan ke fragment
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil username yang dikirim dari LoginActivity
        username = intent.getStringExtra("username") ?: "-"

        // Tampilkan HomeFragment pertama kali
        if (savedInstanceState == null) {
            val homeFragment = HomeFragment()
            val args = Bundle()
            args.putString("username", username)
            homeFragment.arguments = args
            replaceFragment(homeFragment)
            binding.bottomNavigation.selectedItemId = R.id.nav_home
        }

        // Listener bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val homeFragment = HomeFragment()
                    val args = Bundle()
                    args.putString("username", username)
                    homeFragment.arguments = args
                    replaceFragment(homeFragment)
                    true
                }
                R.id.nav_service -> {
                    replaceFragment(ListFragment())
                    true
                }
                R.id.nav_profile -> {
                    val profilFragment = ProfilFragment()
                    val args = Bundle()
                    args.putString("username", username)
                    profilFragment.arguments = args
                    replaceFragment(profilFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}