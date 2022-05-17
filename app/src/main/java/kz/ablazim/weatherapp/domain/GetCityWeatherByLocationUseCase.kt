package kz.ablazim.weatherapp.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.weatherapp.base.UseCase
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway

class GetCityWeatherByLocationUseCase(
    private val cityWeatherRemoteGateway: CityWeatherRemoteGateway,
) : UseCase<GetCityWeatherByLocationUseCase.Param, CityWeatherInfo>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Param): CityWeatherInfo =
        cityWeatherRemoteGateway.getCityNameByLocation(parameters.longitude, parameters.latitude)

    data class Param(val longitude: String, val latitude: String)
}