package com.example.aplikasisederhana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplikasisederhana.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    // Data servis yang sama seperti di ServiceListActivity sebelumnya
    private val serviceList = listOf(
        Service(1, "Service LED TV",
            "Perbaikan layar bergaris/mati total", "Teknisi Agung", 350000),
        Service(2, "Service Laptop",
            "Instalasi ulang & ganti keyboard", "Teknisi Charli", 150000),
        Service(3, "Service AC",
            "Isi freon & ganti kompresor", "Teknisi Endo", 250000),
        Service(4, "Service Handphone",
            "Ganti layar, baterai & konektor", "Teknisi Budi", 200000),
        Service(5, "Service Printer",
            "Ink, laser, dotmatrix & roller", "Teknisi Dini", 120000)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pasang adapter yang sudah ada (ServiceAdapter.kt tidak diubah)
        val adapter = ServiceAdapter(serviceList) { service ->
            Toast.makeText(
                requireContext(),
                "Detail: ${service.type} - ${service.technician}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvServices.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}