package com.example.weatherdiary.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherdiary.data.repository.WeatherRepository
import com.example.weatherdiary.databinding.FragmentWeatherBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private val weatherRepository = WeatherRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            val weatherCurrentList = weatherRepository.getCurrentList(1835847)
            Log.e("Weather","$weatherCurrentList.toString()")

            binding.weatherText.text = weatherCurrentList.let {
                it.weather[0].description
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}