package com.nkot.mvvmandrepositorysample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nkot.mvvmandrepositorysample.R
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepository
import com.nkot.mvvmandrepositorysample.data.cash.WeatherInfoRepositoryLocalCashSource
import com.nkot.mvvmandrepositorysample.data.remote.WeatherInfoRepositoryRemoteSource
import com.nkot.mvvmandrepositorysample.databinding.ActivityMainBinding
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            getWeatherInfo()
        }
    }

    private fun getWeatherInfo() {

    }
}
