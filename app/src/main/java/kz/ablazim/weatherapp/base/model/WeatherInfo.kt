package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("dt")
    val date: Long,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long,
    @SerializedName("moonrise")
    val moonrise: Long,
    @SerializedName("moonset")
    val moonset: Long,
    @SerializedName("moon_phase")
    val moonPhase: Double,
    @SerializedName("temp")
    val temperature: TemperatureInfo,
    @SerializedName("feels_like")
    val feelsLike: FeelsLikeInfo,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDegree: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: Double,
    @SerializedName("uvi")
    val uvi: Double
)