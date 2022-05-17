package kz.ablazim.weatherapp.domain

import kz.ablazim.weatherapp.di.InjectionModule
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule : InjectionModule {
    override fun create(): Module = module {
        single { GetLocationByName(get()) }
        single { GetCityWeatherByLocationUseCase(get()) }
    }
}