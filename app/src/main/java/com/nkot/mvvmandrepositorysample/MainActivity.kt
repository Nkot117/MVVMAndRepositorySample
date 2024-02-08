package com.nkot.mvvmandrepositorysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        fetchWeatherInfo()
    }

    private fun fetchWeatherInfo() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val weatherInfoApiService = retrofit.create(WeatherInfoApiService::class.java)

        val apiKey = BuildConfig.OWM_API_KEY
        GlobalScope.launch {
            val response = weatherInfoApiService.fetchWeatherInfo("London", apiKey).execute()
            if (response.isSuccessful) {
                val weatherInfo = response.body()
                Log.d("MainActivity", "熊倉：Weather Info: $weatherInfo")
            } else {
                Log.d("MainActivity", "熊倉：Weather Info: Failed to fetch data.")
            }
        }
    }
}
