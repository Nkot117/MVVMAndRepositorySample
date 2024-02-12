package com.nkot.mvvmandrepositorysample.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInfoApiService {
    @GET("data/2.5/weather")
    fun fetchWeatherInfo(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
    ): Call<NetworkWeatherInfo>
}
