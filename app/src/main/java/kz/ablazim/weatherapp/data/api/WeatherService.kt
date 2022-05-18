package kz.ablazim.weatherapp.data.api

import kz.ablazim.weatherapp.base.model.CityWeatherDaysInfo
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

    @GET("data/2.5/onecall")
    suspend fun getWeatherForPeriod(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String,
        @Query("appid") appId: String
    ): CityWeatherDaysInfo
}