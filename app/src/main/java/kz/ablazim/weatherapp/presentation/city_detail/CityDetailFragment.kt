package kz.ablazim.weatherapp.presentation.city_detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.base.BaseConverter
import kz.ablazim.weatherapp.databinding.FragmentCityDetailBinding
import kz.ablazim.weatherapp.extensions.observeNotNull
import kz.ablazim.weatherapp.utils.args
import kz.ablazim.weatherapp.utils.withArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

private const val EXTRA_LAT = "EXTRA_LAT"
private const val EXTRA_LON = "EXTRA_LON"
private const val EXTRA_CITY_NAME = "EXTRA_CITY_NAME"
private const val EXTRA_TEMP = "EXTRA_TEMP"
private const val EXTRA_TEMP_DESC = "EXTRA_TEMP_DESC"
private const val EXTRA_FEELS_LIKE = "EXTRA_FEELS_LIKE"
private const val EXTRA_MAX_TEMP = "EXTRA_MAX_TEMP"
private const val EXTRA_MIN_TEMP = "EXTRA_MIN_TEMP"
private const val EXTRA_WIND_SPEED = "EXTRA_WIND_SPEED"

class CityDetailFragment : Fragment(R.layout.fragment_city_detail) {

    companion object {
        fun create(
            latitude: String,
            longitude: String,
            cityName: String,
            temp: String,
            tempDescription: String,
            feelsLike: String,
            maxTemp: String,
            minTemp: String,
            windSpeed: String
        ) =
            CityDetailFragment().withArgs(
                EXTRA_LAT to latitude,
                EXTRA_LON to longitude,
                EXTRA_CITY_NAME to cityName,
                EXTRA_TEMP to temp,
                EXTRA_TEMP_DESC to tempDescription,
                EXTRA_FEELS_LIKE to feelsLike,
                EXTRA_MAX_TEMP to maxTemp,
                EXTRA_MIN_TEMP to minTemp,
                EXTRA_WIND_SPEED to windSpeed
            )
    }

    private val latitude: String by args(EXTRA_LAT)
    private val longitude: String by args(EXTRA_LON)
    private val cityName: String by args(EXTRA_CITY_NAME)
    private val temp: String by args(EXTRA_TEMP)
    private val tempDesc: String by args(EXTRA_TEMP_DESC)
    private val feelsLike: String by args(EXTRA_FEELS_LIKE)
    private val maxTemp: String by args(EXTRA_MAX_TEMP)
    private val minTemp: String by args(EXTRA_MIN_TEMP)
    private val windSpeed: String by args(EXTRA_WIND_SPEED)

    private lateinit var binding: FragmentCityDetailBinding
    private val viewModel: CityDetailViewModel by viewModel() { parametersOf(latitude, longitude) }

    private val cityDetailAdapter: CityDetailAdapter by lazy {
        CityDetailAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCityDetailBinding.bind(view)

        with(binding) {
            toolbar.title = getString(R.string.city_weather_today, cityName)
            toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
            temperatureTextView.text = getString(R.string.temperature_C, temp)
            temperatureDescriptionTextView.text = tempDesc
            feelsLikeTextView.text = getString(
                R.string.feels_like,
                BaseConverter.fromKelvinToCelsius(feelsLike.toDouble())
            )
            maxTemperatureTextView.text =
                getString(R.string.max_temp, BaseConverter.fromKelvinToCelsius(maxTemp.toDouble()))
            minTemperatureTextView.text =
                getString(R.string.min_temp, BaseConverter.fromKelvinToCelsius(minTemp.toDouble()))
            windSpeedTextView.text = getString(R.string.wind_speed, windSpeed)

            sevenDayWeatherRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            sevenDayWeatherRecyclerView.adapter = cityDetailAdapter
            sevenDayWeatherRecyclerView.itemAnimator = DefaultItemAnimator()
        }

        viewModel.progressLoading.observeNotNull(viewLifecycleOwner) { isLoading ->
            binding.progressStateView.isVisible = isLoading
        }

        viewModel.weatherList.observeNotNull(viewLifecycleOwner) { weatherList ->
            cityDetailAdapter.setItems(weatherList)
        }
    }
}