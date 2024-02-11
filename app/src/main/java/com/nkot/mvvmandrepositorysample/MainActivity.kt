package com.nkot.mvvmandrepositorysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepository
import com.nkot.mvvmandrepositorysample.data.cash.WeatherInfoRepositoryLocalCashSource
import com.nkot.mvvmandrepositorysample.data.remote.WeatherInfoRepositoryRemoteSource
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        GlobalScope.launch {
            val weatherInfoRepository = WeatherInfoRepository(
                WeatherInfoRepositoryRemoteSource(WeatherInfoApiService.WeatherInfoApiServiceFactory.create()),
                WeatherInfoRepositoryLocalCashSource(applicationContext)
            )

            val weatherInfo = weatherInfoRepository.refreshWeatherInfo("London")
            Log.d("MainActivity", "テストログ：WeatherInfo: $weatherInfo")
        }
    }
}
