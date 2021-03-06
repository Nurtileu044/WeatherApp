package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class AdditionalWeatherInfo(
    @SerializedName("type")
    val type: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("message")
    val message: Double,
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long
)
