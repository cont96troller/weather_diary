package com.example.weatherdiary.data.model.dto

data class WeatherDTO(
    val weather: List<Weather>
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)