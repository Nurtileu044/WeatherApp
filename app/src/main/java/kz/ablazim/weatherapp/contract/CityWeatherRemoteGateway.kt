package kz.ablazim.weatherapp.contract

import kz.ablazim.weatherapp.base.model.CityWeatherDaysInfo
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.data.API_KEY
import kz.ablazim.weatherapp.data.LIMIT

interface CityWeatherRemoteGateway {
    suspend fun getCityNameByLocation(longitude: String, latitude: String): CityWeatherInfo
    suspend fun getLocationByName(
        cityName: String,
        limit: String = LIMIT,
        appId: String = API_KEY
    ): PlaceInfo

    suspend fun getWeatherForWeekByLocation(
        longitude: String,
        latitude: String
    ): CityWeatherDaysInfo
}