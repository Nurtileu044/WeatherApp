package kz.ablazim.weatherapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kz.ablazim.weatherapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CommonModule : InjectionModule {

    private const val DEFAULT_CONNECT_TIMEOUT_SECONDS = 30L
    private const val DEFAULT_READ_TIMEOUT_SECONDS = 30L

    private const val WEATHER_DATA_BASE_URL = "https://api.openweathermap.org"

    override fun create(): Module = module {
        single {
            GsonBuilder()
                .apply { if (BuildConfig.DEBUG) setPrettyPrinting() }
                .create()
        } bind Gson::class

        single {
            OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    }
                }
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(WEATHER_DATA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .client(get())
                .build()
        } bind Retrofit::class
    }
}