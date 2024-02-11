package com.nkot.mvvmandrepositorysample.data

import com.nkot.mvvmandrepositorysample.model.WeatherInfo

interface WeatherInfoRepositoryInterface {
    suspend fun getWeatherInfo(city: String): WeatherInfo
}
