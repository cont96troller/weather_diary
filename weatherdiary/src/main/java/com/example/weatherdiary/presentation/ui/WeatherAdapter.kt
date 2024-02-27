package com.example.weatherdiary.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherdiary.data.model.dto.WeatherDTO
import com.example.weatherdiary.data.model.entity.WeatherEntity
import com.example.weatherdiary.databinding.ItemWeatherBinding

class WeatherAdapter(
    val list: MutableList<WeatherEntity>
//    private val itemClickListener: ItemClickListener? = null,
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemWeatherBinding.inflate(inflater, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = list[position]
        holder.bind(weather)
    }

    class WeatherViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: WeatherEntity) {
            binding.apply {
                textTextView.text = weather.title
                meanTextView.text = weather.contents
            }
        }
    }

    interface ItemClickListener {
        fun onClick(word: WeatherDTO)
    }
}