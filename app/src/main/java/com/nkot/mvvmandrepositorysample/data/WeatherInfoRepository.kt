package com.nkot.mvvmandrepositorysample.data

import com.nkot.mvvmandrepositorysample.data.cash.WeatherInfoRepositoryLocalCashSource
import com.nkot.mvvmandrepositorysample.data.remote.WeatherInfoRepositoryRemoteSource
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import javax.inject.Inject

class WeatherInfoRepository @Inject constructor(
    private val weatherInfoRepositoryRemoteSource: WeatherInfoRepositoryRemoteSource,
    private val weatherInfoRepositoryLocalCashSource: WeatherInfoRepositoryLocalCashSource,
) {
    suspend fun refreshWeatherInfo(city: String): Result<DomainWeatherInfo> {
        weatherInfoRepositoryRemoteSource.getWeatherInfo(city).let {
            if(it.isSuccess) {
                it.getOrNull()?.let {
                    weatherInfoRepositoryLocalCashSource.insertWeatherInfo(it)
                    return Result.success(it)
                } ?: return Result.failure(Exception("No weather info found"))
            } else {
                return Result.failure(it.exceptionOrNull()!!)
            }
        }
    }
}
