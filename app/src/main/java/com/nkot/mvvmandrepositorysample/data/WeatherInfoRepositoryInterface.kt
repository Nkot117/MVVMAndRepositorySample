package com.nkot.mvvmandrepositorysample.data

import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo

interface WeatherInfoRepositoryInterface {
    suspend fun getWeatherInfo(city: String): Result<DomainWeatherInfo>
}
