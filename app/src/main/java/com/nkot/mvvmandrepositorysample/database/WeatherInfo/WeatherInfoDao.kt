package com.nkot.mvvmandrepositorysample.database.WeatherInfo

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface WeatherInfoDao {
    @Insert
    suspend fun insert(weatherInfoEntity: WeatherInfoEntity)
}
