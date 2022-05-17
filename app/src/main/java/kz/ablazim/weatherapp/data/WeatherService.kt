package kz.ablazim.weatherapp.data

import kz.ablazim.weatherapp.base.model.PlaceInfo
import kz.ablazim.weatherapp.base.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/weather")
    suspend fun getCityWeatherByLocation(
        @Query("lat") lat: String,
        @Query("lon") long: String,
        @Query("appid") appId: String
    ): WeatherResponse

    @GET("geo/1.0/direct")
    suspend fun getLocationByName(
        @Query("q") cityName: String,
        @Query("limit") limit: String,
        @Query("appid") appId: String
    ): List<PlaceInfo>
}