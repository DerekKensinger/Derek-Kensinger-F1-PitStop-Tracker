package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ErgastService {
    @GET("pitstops/{season}/{round}/stops.json")
    suspend fun getPitStops(
        @Path("season") season: Int,
        @Path("round") round: Int
    ): Response<PitStopResponse>
}

suspend fun getPitStops(season: Int, round: Int): List<PitStop> {
    val service = Retrofit.Builder()
        .baseUrl("https://ergast.com/api/f1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ErgastService::class.java)

    val response = service.getPitStops(season, round)
    val pitStopResponse = response.body() ?: return emptyList()
    return pitStopResponse.raceTable.races.flatMap { it.pitStops }

}




