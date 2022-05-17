package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class WindInfo(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double
)
