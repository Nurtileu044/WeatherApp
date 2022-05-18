package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class CityInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coordinate: CoordinateInfo,
    @SerializedName("country")
    val country: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timezone")
    val timezone: Int
)