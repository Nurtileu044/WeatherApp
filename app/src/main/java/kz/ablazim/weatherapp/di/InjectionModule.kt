package kz.ablazim.weatherapp.di

import org.koin.core.module.Module

interface InjectionModule {
    fun create(): Module
}