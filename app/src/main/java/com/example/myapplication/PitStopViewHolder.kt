package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.PitStop
import com.example.myapplication.R


class PitStopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val raceNameTextView = itemView.findViewById<TextView>(R.id.raceNameTextView)
        private val driverNameTextView = itemView.findViewById<TextView>(R.id.driverNameTextView)
        private val stopTextView = itemView.findViewById<TextView>(R.id.stopTextView)
        private val lapTextView = itemView.findViewById<TextView>(R.id.lapTextView)
        private val timeTextView = itemView.findViewById<TextView>(R.id.timeTextView)

        fun bind(pitStop: PitStop) {
            raceNameTextView.text = pitStop.raceName
            driverNameTextView.text = pitStop.driverName
            stopTextView.text = pitStop.stop.toString()
            lapTextView.text = pitStop.lap.toString()
            timeTextView.text = pitStop.time
        }
}

