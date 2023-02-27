package com.example.myapplication

data class PitStopResponse(
    val raceTable: RaceTable
)

data class RaceTable(
    val races: List<Race>
)

data class Race(
    val season: String,
    val round: String,
    val raceName: String,
    val circuit: Circuit,
    val pitStops: List<PitStop>
)

data class Circuit(
    val circuitName: String
)
