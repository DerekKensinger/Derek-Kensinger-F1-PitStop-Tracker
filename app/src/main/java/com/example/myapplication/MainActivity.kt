package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("StaticFieldLeak")
private lateinit var seasonEditText: EditText
@SuppressLint("StaticFieldLeak")
private lateinit var roundEditText: EditText
@SuppressLint("StaticFieldLeak")
private lateinit var teamEditText: EditText
@SuppressLint("StaticFieldLeak")
private lateinit var searchButton: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        seasonEditText = findViewById(R.id.seasonEditText)
        roundEditText = findViewById(R.id.roundEditText)
        teamEditText = findViewById(R.id.teamEditText)
        searchButton = findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            val season = seasonEditText.text.toString().toInt()
            val round = roundEditText.text.toString().toInt()
            val team = teamEditText.text.toString()

            // Call the getPitStops() function with the user input
            val pitStops = getPitStops(season, round)

            // Filter the results by team name
            val filteredPitStops = pitStops.filter { it.driverName.contains(team, ignoreCase = true) }

            // Display the results in the UI
            val pitStopList = findViewById<RecyclerView>(R.id.pitStopList)
            pitStopList.layoutManager = LinearLayoutManager(this)
            
            val adapter = PitStopAdapter(pitStops)
            pitStopList.adapter = adapter

        }

    }

}