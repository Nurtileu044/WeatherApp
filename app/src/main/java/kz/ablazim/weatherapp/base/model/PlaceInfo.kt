package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class PlaceInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("local_names")
    val localNames: LocalName,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("country")
    val country: String
)
