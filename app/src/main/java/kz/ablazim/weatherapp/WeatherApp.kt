package kz.ablazim.weatherapp

import android.app.Application
import kz.ablazim.weatherapp.data.DataModule
import kz.ablazim.weatherapp.di.CommonModule
import kz.ablazim.weatherapp.domain.DomainModule
import kz.ablazim.weatherapp.presentation.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            val androidContext = androidContext(this@WeatherApp)
            modules(
                CommonModule.create(),
                DataModule.create(),
                DomainModule.create(),
                PresentationModule.create()
            )
        }
    }
}