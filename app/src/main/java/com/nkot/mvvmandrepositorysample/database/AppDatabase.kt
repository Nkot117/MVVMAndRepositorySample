package com.nkot.mvvmandrepositorysample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoDao
import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoEntity

@Database(entities = [WeatherInfoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weatherInfoDao(): WeatherInfoDao

    companion object {
     @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
