package com.nkot.mvvmandrepositorysample.domain

import com.nkot.mvvmandrepositorysample.database.WeatherInfo.WeatherInfoEntity
import java.util.Date

data class DomainWeatherInfo(
    val city: String,
    val weather: String,
)

fun DomainWeatherInfo.asDatabaseModel(): WeatherInfoEntity {
    return WeatherInfoEntity(
        city = city,
        weather = weather,
        created = Date()
    )
}
