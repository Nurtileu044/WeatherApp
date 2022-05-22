package kz.ablazim.weatherapp.domain

import kz.ablazim.weatherapp.di.InjectionModule
import kz.ablazim.weatherapp.domain.usecase.GetCityWeatherByLocationUseCase
import kz.ablazim.weatherapp.domain.usecase.GetLocationByNameUseCase
import kz.ablazim.weatherapp.domain.usecase.GetWeatherForPeriodUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule : InjectionModule {
    override fun create(): Module = module {
        single { GetLocationByNameUseCase(get()) }
        single { GetCityWeatherByLocationUseCase(get()) }
        single { GetWeatherForPeriodUseCase(get()) }
    }
}