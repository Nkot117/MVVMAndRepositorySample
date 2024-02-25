package com.nkot.mvvmandrepositorysample.data.cash

import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepositoryInterface
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoDao
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.asDomainModel
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import com.nkot.mvvmandrepositorysample.domain.asDatabaseModel
import javax.inject.Inject

class WeatherInfoRepositoryLocalCashSource @Inject constructor(private val weatherInfoDao: WeatherInfoDao) :
    WeatherInfoRepositoryInterface {
    suspend fun insertWeatherInfo(weatherInfo: DomainWeatherInfo) {
        weatherInfoDao.insert(weatherInfo.asDatabaseModel())
    }

    override suspend fun getWeatherInfo(city: String): Result<DomainWeatherInfo> {
        return  try {
            val weatherInfo = weatherInfoDao.getLatestWeatherInfo(city)
            if (weatherInfo != null) {
                Result.success(weatherInfo.asDomainModel())
            } else {
                Result.failure(Exception("No weather info found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }


    }
}
