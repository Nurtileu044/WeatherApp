package kz.ablazim.weatherapp.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.weatherapp.base.UseCase
import kz.ablazim.weatherapp.base.model.WeatherData
import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway

class GetWeatherForWeek(private val gateway: CityWeatherRemoteGateway) :
    UseCase<GetWeatherForWeek.Param, List<WeatherData>>() {

    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Param): List<WeatherData> {
        val weatherInfoForWeek = gateway.getWeatherForWeekByLocation(
            longitude = parameters.longitude,
            latitude = parameters.latitude
        )
        return weatherInfoForWeek.dailyWeatherList.map { info ->
            WeatherData(
                date = info.date,
                dayTemp = info.temperature.day,
                nightTemp = info.temperature.night
            )
        }
    }

    data class Param(val latitude: String, val longitude: String)
}