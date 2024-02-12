package com.nkot.mvvmandrepositorysample.data.cash

import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoDao
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoEntity
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import java.util.Date
import javax.inject.Inject

class WeatherInfoRepositoryLocalCashSource @Inject constructor(private val weatherInfoDao: WeatherInfoDao) {
    suspend fun insertWeatherInfo(weatherInfo: DomainWeatherInfo) {
        val info = WeatherInfoEntity(
            city = weatherInfo.city,
            weather = weatherInfo.weather,
            created = Date()
        )
        weatherInfoDao.insert(info)
    }
}
