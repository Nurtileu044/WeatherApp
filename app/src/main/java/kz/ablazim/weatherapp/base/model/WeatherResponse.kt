package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord")
    val coord: CoordinateInfo,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: WeatherDetail,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: WindInfo,
    @SerializedName("clouds")
    val clouds: CloudInfo,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("sys")
    val sys: AdditionalWeatherInfo,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val code: Int
)