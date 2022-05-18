package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class TemperatureInfo(
    @SerializedName("day")
    val day: Double,
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    val max: Double,
    @SerializedName("night")
    val night: Double,
    @SerializedName("eve")
    val evening: Double,
    @SerializedName("morn")
    val morn: Double
)