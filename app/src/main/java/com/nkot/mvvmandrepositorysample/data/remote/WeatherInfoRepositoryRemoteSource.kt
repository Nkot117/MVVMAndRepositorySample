package com.nkot.mvvmandrepositorysample.data.remote

import com.nkot.mvvmandrepositorysample.BuildConfig
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepositoryInterface
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService
import com.nkot.mvvmandrepositorysample.network.asDomainModel
import javax.inject.Inject

class WeatherInfoRepositoryRemoteSource @Inject constructor(private val weatherInfoApiService: WeatherInfoApiService) :
    WeatherInfoRepositoryInterface {
    private val apiKey = BuildConfig.OWM_API_KEY
    override suspend fun getWeatherInfo(city: String): DomainWeatherInfo {
        val response =
            weatherInfoApiService.fetchWeatherInfo(city, apiKey).execute()

        return response.body()!!.asDomainModel()
    }
}
