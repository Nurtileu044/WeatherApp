package kz.ablazim.weatherapp.data

import kz.ablazim.weatherapp.base.BaseConverter
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.base.model.WeatherResponse

object WeatherConverter {
    fun fromServer(weather: WeatherResponse): CityWeatherInfo {
        return CityWeatherInfo(
            cityName = weather.name,
            weatherDescp = weather.weather[0].main,
            temperature = BaseConverter.fromKelvinToCelsius(weather.main.temp),
            latitude = weather.coord.lat,
            longitude = weather.coord.lon,
            feelsLike = weather.main.feelsLike.toString(),
            maxTemp = weather.main.tempMax.toString(),
            minTemp = weather.main.tempMin.toString(),
            windSpeed = weather.wind.speed.toString()
        )
    }
}