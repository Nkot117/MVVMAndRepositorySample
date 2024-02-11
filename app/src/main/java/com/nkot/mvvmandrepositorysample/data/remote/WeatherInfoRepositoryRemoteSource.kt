package com.nkot.mvvmandrepositorysample.data.remote

import com.nkot.mvvmandrepositorysample.BuildConfig
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepositoryInterface
import com.nkot.mvvmandrepositorysample.model.WeatherInfo
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService

class WeatherInfoRepositoryRemoteSource(private val weatherInfoApiService: WeatherInfoApiService) :
    WeatherInfoRepositoryInterface {
    override suspend fun getWeatherInfo(city: String): WeatherInfo {
        val response =
            weatherInfoApiService.fetchWeatherInfo(city, BuildConfig.OWM_API_KEY).execute()
        val weatherInfo = response.body()
        return weatherInfo!!
    }
}
