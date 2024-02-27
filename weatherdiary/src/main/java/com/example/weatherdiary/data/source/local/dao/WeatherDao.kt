package com.example.weatherdiary.data.source.local.dao

import androidx.room.*
import com.example.weatherdiary.data.model.entity.WeatherEntity

@Dao
interface WeatherDao {
    @Query("SELECT * from weather ORDER BY id DESC")
    fun getAll(): List<WeatherEntity>
    @Insert
    fun insert(word: WeatherEntity)

    @Delete
    fun delete(word: WeatherEntity)

    @Update
    fun update(word: WeatherEntity)

}