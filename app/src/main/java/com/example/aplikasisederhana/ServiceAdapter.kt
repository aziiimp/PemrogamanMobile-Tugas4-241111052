package com.example.aplikasisederhana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(
    private val services: List<Service>,
    private val onItemClick: (Service) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvType: TextView = view.findViewById(R.id.tvServiceType)
        val tvDesc: TextView = view.findViewById(R.id.tvDescription)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = services[position]
        holder.tvType.text = item.type
        holder.tvDesc.text = item.description
        holder.tvPrice.text = item.getFormattedPrice()
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = services.size
}