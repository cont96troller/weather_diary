package com.example.weatherdiary.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    val title : String,
    val contents : String,
    val weather : String,
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
)
