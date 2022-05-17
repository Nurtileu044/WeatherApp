package kz.ablazim.weatherapp.data

import kz.ablazim.weatherapp.contract.CityWeatherRemoteGateway
import kz.ablazim.weatherapp.di.InjectionModule
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

object DataModule : InjectionModule {
    override fun create(): Module = module {
        single<CityWeatherRemoteGateway> { WeatherApi(get<Retrofit>().create(WeatherService::class.java)) }
    }
}