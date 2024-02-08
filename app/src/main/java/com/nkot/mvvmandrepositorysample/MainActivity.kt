package com.nkot.mvvmandrepositorysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRemoteRepository
import com.nkot.mvvmandrepositorysample.network.WeatherInfoApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        GlobalScope.launch {
            val weatherInfo = WeatherInfoRemoteRepository(
                WeatherInfoApiService.WeatherInfoApiServiceFactory.create()
            ).getWeatherInfo("Tokyo")
            Log.d("MainActivity", "熊倉：Weather Info: $weatherInfo")
        }
    }
}
