package kz.ablazim.weatherapp.data.api

import kz.ablazim.weatherapp.base.model.CityWeatherDaysInfo
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway
import kz.ablazim.weatherapp.data.WeatherConverter

const val API_KEY = "91aad420520dfe8c74f218239f1cb064"
const val LIMIT = "1"
const val WEATHER_EXCLUDE_FIELDS = "minutely, hourly, alerts, current"

class WeatherApi(private val service: WeatherService) : CityWeatherRemoteGateway {
    override suspend fun getCityNameByLocation(
        longitude: String,
        latitude: String
    ): CityWeatherInfo {
        val weather = service.getCityWeatherByLocation(
            lat = latitude,
            long = longitude,
            appId = API_KEY
        )
        return WeatherConverter.fromServer(weather)
    }

    override suspend fun getLocationByName(
        cityName: String,
        limit: String,
        appId: String
    ): PlaceInfo = service.getLocationByName(cityName = cityName, limit = LIMIT, appId = API_KEY)[0]

    override suspend fun getWeatherForPeriodByLocation(
        longitude: String,
        latitude: String
    ): CityWeatherDaysInfo = service.getWeatherForPeriod(
        lat = latitude,
        lon = longitude,
        exclude = WEATHER_EXCLUDE_FIELDS,
        appId = API_KEY
    )
}