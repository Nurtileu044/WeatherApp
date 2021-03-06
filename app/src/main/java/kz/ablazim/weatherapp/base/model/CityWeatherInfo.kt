package kz.ablazim.weatherapp.base.model

data class CityWeatherInfo(
    val cityName: String,
    val weatherDescp: String,
    val temperature: String,
    val latitude: Double,
    val longitude: Double,
    val feelsLike: String,
    val maxTemp: String,
    val minTemp: String,
    val windSpeed: String
)
