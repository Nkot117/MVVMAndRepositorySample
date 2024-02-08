package com.nkot.mvvmandrepositorysample.data

import android.util.Log
import com.nkot.mvvmandrepositorysample.BuildConfig
import com.nkot.mvvmandrepositorysample.model.WeatherInfo
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService

interface WeatherInfoRepository {
    suspend fun getWeatherInfo(city: String): WeatherInfo
}

class WeatherInfoRemoteRepository(private val weatherInfoApiService: WeatherInfoApiService) :
    WeatherInfoRepository {
    override suspend fun getWeatherInfo(city: String): WeatherInfo {
        val response =
            weatherInfoApiService.fetchWeatherInfo(city, BuildConfig.OWM_API_KEY).execute()
        val weatherInfo = response.body()
        return weatherInfo!!
    }
}
