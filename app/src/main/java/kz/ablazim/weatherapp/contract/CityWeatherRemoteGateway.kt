package kz.ablazim.weatherapp.contract

import kz.ablazim.weatherapp.base.model.CityWeatherDaysInfo
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.data.api.API_KEY
import kz.ablazim.weatherapp.data.api.LIMIT

interface CityWeatherRemoteGateway {
    suspend fun getCityNameByLocation(longitude: String, latitude: String): CityWeatherInfo
    suspend fun getLocationByName(
        cityName: String,
        limit: String = LIMIT,
        appId: String = API_KEY
    ): PlaceInfo

    suspend fun getWeatherForPeriodByLocation(
        longitude: String,
        latitude: String
    ): CityWeatherDaysInfo
}