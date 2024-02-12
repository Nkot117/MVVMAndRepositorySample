package com.nkot.mvvmandrepositorysample.data

import com.nkot.mvvmandrepositorysample.data.cash.WeatherInfoRepositoryLocalCashSource
import com.nkot.mvvmandrepositorysample.data.remote.WeatherInfoRepositoryRemoteSource
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import javax.inject.Inject

class WeatherInfoRepository @Inject constructor(
    private val weatherInfoRepositoryRemoteSource: WeatherInfoRepositoryRemoteSource,
    private val weatherInfoRepositoryLocalCashSource: WeatherInfoRepositoryLocalCashSource,
) {

    suspend fun refreshWeatherInfo(city: String) : DomainWeatherInfo {
        weatherInfoRepositoryRemoteSource.getWeatherInfo(city).let {
            weatherInfoRepositoryLocalCashSource.insertWeatherInfo(it)
            return it
        }
    }
}
