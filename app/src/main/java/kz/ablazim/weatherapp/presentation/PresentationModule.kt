package kz.ablazim.weatherapp.presentation

import kz.ablazim.weatherapp.di.InjectionModule
import kz.ablazim.weatherapp.presentation.city_detail.CityDetailViewModel
import kz.ablazim.weatherapp.presentation.city_list.CityListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule : InjectionModule {
    override fun create(): Module = module {
        viewModel { CityListViewModel(get(), get()) }
        viewModel { (latitude: String, longitude: String) ->
            CityDetailViewModel(
                latitude,
                longitude,
                get()
            )
        }
    }
}