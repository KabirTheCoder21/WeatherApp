package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:WeatherViewModel by viewModels()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResp.observe(this) {
            binding.apply {
                tvCityName.text = "Varanasi"
                tvDescription.text = it.description
                tvTemperature.text = it.temperature
                tvWind.text = it.wind

                val forecast = it.forecast
                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"


            }
        }
    }
}