package kz.ablazim.weatherapp

sealed class ScreenCompose(val route: String) {
    object CityListScreen : ScreenCompose("cityList")
    object CityDetailScreen : ScreenCompose("cityDetail")
}