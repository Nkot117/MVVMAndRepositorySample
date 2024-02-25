package com.nkot.mvvmandrepositorysample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nkot.mvvmandrepositorysample.data.WeatherInfoRepository
import com.nkot.mvvmandrepositorysample.domain.DomainWeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val weatherInfoRepository: WeatherInfoRepository) :
    ViewModel() {
    private var _weatherInfo = MutableLiveData<DomainWeatherInfo>()
    val weatherInfo: MutableLiveData<DomainWeatherInfo>
        get() = _weatherInfo

    fun getWeatherInfo(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherInfoRepository.refreshWeatherInfo(city).also {
                _weatherInfo.postValue(it)
            }
        }
    }
}
