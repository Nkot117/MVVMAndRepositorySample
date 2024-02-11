package com.nkot.mvvmandrepositorysample.data

import android.util.Log
import com.nkot.mvvmandrepositorysample.BuildConfig
import com.nkot.mvvmandrepositorysample.data.remote.WeatherInfoRepositoryRemoteSource
import com.nkot.mvvmandrepositorysample.model.WeatherInfo
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService

class WeatherInfoRepository(private val weatherInfoRepositoryRemoteSource: WeatherInfoRepositoryRemoteSource){
    suspend fun getWeatherInfo(city: String): WeatherInfo {
        return weatherInfoRepositoryRemoteSource.getWeatherInfo(city)
    }
}
