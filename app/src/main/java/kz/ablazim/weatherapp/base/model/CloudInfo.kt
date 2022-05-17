package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class CloudInfo(
    @SerializedName("all")
    val all: Int
)
