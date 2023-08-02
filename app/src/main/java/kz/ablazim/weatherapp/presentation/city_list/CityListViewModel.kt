package kz.ablazim.weatherapp.presentation.city_list

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.base.Action
import kz.ablazim.weatherapp.base.BaseViewModel
import kz.ablazim.weatherapp.base.SingleLiveEvent
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.domain.usecase.GetCityWeatherByLocationUseCase
import kz.ablazim.weatherapp.domain.usecase.GetLocationByNameUseCase
import timber.log.Timber

private const val ALMATY = "Almaty"
private const val NUR_SULTAN = "Nur-Sultan"

class CityListViewModel(
    private val getLocationByNameUseCase: GetLocationByNameUseCase,
    private val getCityWeatherByLocationUseCase: GetCityWeatherByLocationUseCase
) : BaseViewModel() {
    private val _actions = SingleLiveEvent<CityListAction>()
    val actions: LiveData<CityListAction> = _actions

    private val _progressLoading = MutableLiveData(false)
    val progressLoading: LiveData<Boolean> = _progressLoading

    private val _cityInfo = MutableLiveData<MutableList<CityWeatherInfo>>()
    val cityInfo: LiveData<MutableList<CityWeatherInfo>> = _cityInfo

    init {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                val almatyLocation =
                    getLocationByNameUseCase(GetLocationByNameUseCase.Param(cityName = ALMATY))
                val nurSultanLocation =
                    getLocationByNameUseCase(GetLocationByNameUseCase.Param(cityName = NUR_SULTAN))

                val initialCityList = mutableListOf(
                    getCityWeatherByLocationUseCase(
                        GetCityWeatherByLocationUseCase.Param(
                            longitude = almatyLocation.lon,
                            latitude = almatyLocation.lat
                        )
                    ),
                    getCityWeatherByLocationUseCase(
                        GetCityWeatherByLocationUseCase.Param(
                            longitude = nurSultanLocation.lon,
                            latitude = nurSultanLocation.lat
                        )
                    )
                )
                _cityInfo.postValue(initialCityList)
            },
            handleError = {
                Timber.e(it, "Could not send")
            })
    }

    fun onItemClicked(info: CityWeatherInfo) {
        _actions.value = CityListAction.ShowCityDetailScreen(info)
    }

    fun onMenuItemClicked(menuItem: MenuItem) {
        if (menuItem.itemId == R.id.addCity) {
            _actions.value = CityListAction.AddNewCity
        }
    }

    fun onNewCityNameAdded(cityName: String) {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                val cityLocation =
                    getLocationByNameUseCase(GetLocationByNameUseCase.Param(cityName = cityName))
                val cityWeatherInfo = getCityWeatherByLocationUseCase(
                    GetCityWeatherByLocationUseCase.Param(
                        longitude = cityLocation.lon,
                        latitude = cityLocation.lat
                    )
                )
                val list = _cityInfo.value
                list?.add(cityWeatherInfo)
                _cityInfo.postValue(list)
            },
            handleError = {
                Timber.e(it, "Could not add new city")
            }
        )
    }
}

sealed class CityListAction : Action {
    object AddNewCity : CityListAction()
    data class ShowCityDetailScreen(val cityWeatherInfo: CityWeatherInfo) : CityListAction()
}