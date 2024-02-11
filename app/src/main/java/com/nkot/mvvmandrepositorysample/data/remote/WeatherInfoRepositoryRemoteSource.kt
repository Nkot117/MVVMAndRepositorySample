package com.nkot.mvvmandrepositorysample.data.remote

import com.nkot.mvvmandrepositorysample.BuildConfig
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepositoryInterface
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService
import com.nkot.mvvmandrepositorysample.network.asDomainModel

class WeatherInfoRepositoryRemoteSource(private val weatherInfoApiService: WeatherInfoApiService) :
    WeatherInfoRepositoryInterface {
    override suspend fun getWeatherInfo(city: String): DomainWeatherInfo {
        val response =
            weatherInfoApiService.fetchWeatherInfo(city, BuildConfig.OWM_API_KEY).execute()

        return response.body()!!.asDomainModel()
    }
}
