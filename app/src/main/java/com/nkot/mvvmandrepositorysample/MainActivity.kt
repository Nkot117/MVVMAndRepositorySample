package com.nkot.mvvmandrepositorysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var weatherInfoRepository: WeatherInfoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        GlobalScope.launch {
            val weatherInfo = weatherInfoRepository.refreshWeatherInfo("London")
            Log.d("MainActivity", "テストログ：WeatherInfo: $weatherInfo")
        }
    }
}
