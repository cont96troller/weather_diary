package com.example.weatherdiary.data.repository

import com.example.weatherdiary.data.source.remote.api.RetrofitInstance

class WeatherRepository {
    private val apiKey: String = "d36d81339b59c0868af503708d9057b8"
    private val client = RetrofitInstance.createApi()

    suspend fun getCurrentList(id: Int) = client.getCurrentList(id, apiKey)
}