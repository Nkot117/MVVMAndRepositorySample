package com.nkot.mvvmandrepositorysample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoDao
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoEntity

@Database(entities = [WeatherInfoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weatherInfoDao(): WeatherInfoDao
}
