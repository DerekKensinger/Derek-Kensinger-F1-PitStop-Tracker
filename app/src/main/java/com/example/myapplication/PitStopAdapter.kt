package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PitStopAdapter(private val pitStops: List<PitStop>) : RecyclerView.Adapter<PitStopViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitStopViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pit_stop_item, parent, false)
        return PitStopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PitStopViewHolder, position: Int) {
        holder.bind(pitStops[position])
    }

    override fun getItemCount(): Int {
        return pitStops.size
    }
}
