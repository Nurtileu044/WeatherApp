package kz.ablazim.weatherapp.base.model

data class CityDetailWeather(
    val cityName: String,
    val temperature: String,
    val description: String,
    val feelsLike: String,
    val maxTemp: String,
    val minTemp: String,
    val windSpeed: String
)
