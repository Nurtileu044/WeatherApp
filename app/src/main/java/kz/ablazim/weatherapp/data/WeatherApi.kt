package kz.ablazim.weatherapp.data

import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway

const val API_KEY = "255c24b832f0b3688a1f5d5c2f348ac5"
const val LIMIT = "1"

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
        return CityWeatherInfo(cityName = weather.name, weather = weather.sys.country)
    }

    override suspend fun getLocationByName(
        cityName: String,
        limit: String,
        appId: String
    ): PlaceInfo = service.getLocationByName(cityName = cityName, limit = LIMIT, appId = API_KEY)[0]
}