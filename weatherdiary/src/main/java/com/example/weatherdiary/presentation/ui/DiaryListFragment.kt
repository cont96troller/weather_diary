package com.example.weatherdiary.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherdiary.data.source.local.AppDatabase
import com.example.weatherdiary.databinding.FragmentDiaryBinding

class DiaryListFragment : Fragment(){
    private lateinit var binding:FragmentDiaryBinding
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherAdapter = WeatherAdapter(mutableListOf())
        binding.wordRecyclerView.apply {
            adapter = weatherAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration =
                DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }

        Thread {
            val list = AppDatabase.getInstance(requireContext())?.wordDao()?.getAll() ?: emptyList()
            Log.e("list", "list" + list.toString())
            weatherAdapter.list.addAll(list)
//            weatherAdapter.notifyDataSetChanged()
        }.start()
    }
}