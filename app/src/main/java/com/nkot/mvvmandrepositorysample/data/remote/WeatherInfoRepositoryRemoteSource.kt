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
    override suspend fun getWeatherInfo(city: String): Result<DomainWeatherInfo> {
        return try {
            val response =
                weatherInfoApiService.fetchWeatherInfo(city, apiKey).execute()

            if(response.code() == 200) {
                Result.success(response.body()!!.asDomainModel())
            } else {
                Result.failure(Exception("No weather info found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
