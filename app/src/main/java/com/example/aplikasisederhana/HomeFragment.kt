package com.example.aplikasisederhana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplikasisederhana.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil username dari arguments (dikirim dari MainActivity)
        val username = arguments?.getString("username") ?: "-"
        binding.tvNamaPengguna.text = username

        // Set data status servis
        binding.tvNamaBarang.text = "Laptop ASUS VivoBook"
        binding.tvStatusServis.text = "Sedang Diperbaiki"
        binding.tvTanggalMasuk.text = "Masuk: 20 April 2026"
        binding.tvTotalMasuk.text = "5"
        binding.tvDalamProses.text = "2"
        binding.tvSelesai.text = "3"

        // Navigasi card Daftar Service → ListFragment
        binding.cardServiceMenu.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ListFragment())
                .addToBackStack(null)
                .commit()
        }

        // Card Sparepart (fitur lanjutan)
        binding.cardSparepartMenu.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur Sparepart segera hadir", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}