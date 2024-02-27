package com.example.weatherdiary.data.source.remote.api

import com.example.weatherdiary.data.model.dto.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getCurrentList(
        @Query("id") id: Int,
        @Query("appid") apiKey: String
    ): WeatherDTO
}