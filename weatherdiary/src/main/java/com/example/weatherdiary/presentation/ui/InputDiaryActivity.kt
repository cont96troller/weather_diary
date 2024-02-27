package com.example.weatherdiary.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherdiary.data.model.entity.WeatherEntity
import com.example.weatherdiary.data.source.local.AppDatabase
import com.example.weatherdiary.databinding.ActivityDiaryInputBinding

class InputDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiaryInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.inputDiaryBtn.setOnClickListener {
            add()
        }
    }

    private fun add() {
        val text = binding.titleText.text.toString()
        val mean = binding.contentsText.text.toString()
        val word = WeatherEntity(text, mean, "맑음")

        Thread {
            AppDatabase.getInstance(this)?.wordDao()?.insert(word)
            runOnUiThread {
                Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent().putExtra("isUpdated", true)
            setResult(RESULT_OK,intent)
            finish()
        }.start()
    }
}