package kz.ablazim.weatherapp.base.model

import com.google.gson.annotations.SerializedName

data class LocalName(
    @SerializedName("en")
    val en: String
)
