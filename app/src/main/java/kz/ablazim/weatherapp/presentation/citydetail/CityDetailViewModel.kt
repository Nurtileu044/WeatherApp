package kz.ablazim.weatherapp.presentation.citydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.ablazim.weatherapp.base.BaseViewModel
import kz.ablazim.weatherapp.base.model.WeatherData
import kz.ablazim.weatherapp.domain.usecase.GetWeatherForWeekUseCase
import timber.log.Timber

class CityDetailViewModel(
    private val latitude: String,
    private val longitude: String,
    private val getWeatherForWeekUseCase: GetWeatherForWeekUseCase
) : BaseViewModel() {
    private val _progressLoading = MutableLiveData(false)
    val progressLoading: LiveData<Boolean> = _progressLoading

    private val _weatherList = MutableLiveData<List<WeatherData>>()
    val weatherList: LiveData<List<WeatherData>> = _weatherList

    init {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                _weatherList.postValue(
                    getWeatherForWeekUseCase.invoke(
                        GetWeatherForWeekUseCase.Param(
                            latitude = latitude,
                            longitude = longitude
                        )
                    )
                )
            },
            handleError = {
                Timber.e(it, "Could not get city detail")
            }
        )
    }
}