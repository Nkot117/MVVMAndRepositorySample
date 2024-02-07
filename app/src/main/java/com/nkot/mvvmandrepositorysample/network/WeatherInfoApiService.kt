package com.nkot.mvvmandrepositorysample.network

import com.nkot.mvvmandrepositorysample.model.WeatherInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInfoApiService {
    @GET("data/2.5/weather")
    fun fetchWeatherInfo(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
    ): Call<WeatherInfo>

}
