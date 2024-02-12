package com.nkot.mvvmandrepositorysample.data.cash

import android.content.Context
import com.nkot.mvvmandrepositorysample.database.AppDatabase
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoDao
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoEntity
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import dagger.hilt.android.qualifiers.ActivityContext
import java.util.Date
import javax.inject.Inject

class WeatherInfoRepositoryLocalCashSource @Inject constructor(@ActivityContext private val context: Context) {
    suspend fun insertWeatherInfo(weatherInfo: DomainWeatherInfo) {
        val info = WeatherInfoEntity(
            city = weatherInfo.city,
            weather = weatherInfo.weather,
            created = Date()
        )
        val weatherInfoDao: WeatherInfoDao = AppDatabase.getDatabase(context).weatherInfoDao()
        weatherInfoDao.insert(info)
    }
}
