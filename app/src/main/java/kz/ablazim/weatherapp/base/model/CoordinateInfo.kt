package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class CoordinateInfo(
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)
