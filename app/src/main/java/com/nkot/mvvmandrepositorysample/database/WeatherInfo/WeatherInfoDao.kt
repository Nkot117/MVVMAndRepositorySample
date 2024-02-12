package com.nkot.mvvmandrepositorysample.database.WeatherInfo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherInfoDao {
    @Insert
    suspend fun insert(weatherInfoEntity: WeatherInfoEntity)

    @Query("SELECT * FROM weather_info_table WHERE city = :city ORDER BY created DESC LIMIT 1")
    suspend fun getLatestWeatherInfo(city: String): WeatherInfoEntity
}
