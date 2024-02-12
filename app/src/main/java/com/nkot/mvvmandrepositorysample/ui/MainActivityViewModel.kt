package com.nkot.mvvmandrepositorysample.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val weatherInfoRepository: WeatherInfoRepository) :
    ViewModel() {

    fun getWeatherInfo(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherInfoRepository.refreshWeatherInfo(city)
        }
    }
}
