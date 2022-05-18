package kz.ablazim.weatherapp.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.weatherapp.base.UseCase
import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway

class GetLocationByNameUseCase(private val cityWeatherRemoteGateway: CityWeatherRemoteGateway) :
    UseCase<GetLocationByNameUseCase.Param, PlaceInfo>() {

    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Param) =
        cityWeatherRemoteGateway.getLocationByName(parameters.cityName)

    data class Param(val cityName: String)
}