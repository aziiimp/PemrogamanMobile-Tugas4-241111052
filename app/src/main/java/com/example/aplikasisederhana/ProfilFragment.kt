package com.example.aplikasisederhana

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplikasisederhana.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil username dari arguments
        val username = arguments?.getString("username") ?: "-"

        // Set data profil
        binding.tvNamaProfil.text = username
        binding.tvInfoUsername.text = username
        binding.tvInfoHP.text = "+62 812-3456-7890"
        binding.tvJmlServis.text = "5"
        binding.tvJmlSelesai.text = "3"
        binding.tvJmlProses.text = "2"

        // Tombol Keluar → kembali ke LoginActivity
        binding.btnKeluar.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}