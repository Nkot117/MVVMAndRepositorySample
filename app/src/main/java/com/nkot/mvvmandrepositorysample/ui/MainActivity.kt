package com.nkot.mvvmandrepositorysample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.nkot.mvvmandrepositorysample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            getWeatherInfo()
        }

        viewModel.weatherInfo.observe(this) { weatherInfo ->
            if (weatherInfo != null) {
                binding.cityNameTextView.also {
                    binding.errorTextView.visibility = View.GONE
                    it.text = weatherInfo.city
                    it.visibility = View.VISIBLE
                }
                binding.weatherTextView.also {
                    it.text = weatherInfo.weather
                    it.visibility = View.VISIBLE
                }
                binding.descriptionTextView.visibility = View.VISIBLE
            } else {
                binding.cityNameTextView.visibility = View.GONE
                binding.weatherTextView.visibility = View.GONE
                binding.descriptionTextView.visibility = View.GONE
                binding.errorTextView.visibility = View.VISIBLE
            }

        }
    }

    private fun getWeatherInfo() {
        viewModel.getWeatherInfo(binding.cityNameEditText.text.toString())
    }
}
