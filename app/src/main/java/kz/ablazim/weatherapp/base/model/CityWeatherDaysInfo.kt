package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class CityWeatherDaysInfo(
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val code: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int,
    @SerializedName("daily")
    val dailyWeatherList: List<WeatherInfo>
)