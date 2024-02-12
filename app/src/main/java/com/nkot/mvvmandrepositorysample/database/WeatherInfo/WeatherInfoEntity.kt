package com.nkot.mvvmandrepositorysample.database.WeatherInfo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import java.util.Date

@Entity(tableName = "weather_info_table")
data class WeatherInfoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val city: String,
    val weather: String,
    val created: Date
)

fun WeatherInfoEntity.asDomainModel(): DomainWeatherInfo {
    return DomainWeatherInfo(
        city = city,
        weather = weather,
    )
}
