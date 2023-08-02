package kz.ablazim.weatherapp.presentation.city_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.base.BaseAdapter
import kz.ablazim.weatherapp.base.BaseConverter
import kz.ablazim.weatherapp.base.BaseViewHolder
import kz.ablazim.weatherapp.base.model.WeatherData
import kz.ablazim.weatherapp.databinding.ItemCityWeatherDetailBinding
import kz.ablazim.weatherapp.utils.DateTimeUtils

class CityDetailAdapter : BaseAdapter<WeatherData>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = CityDetailViewHolder(
        ItemCityWeatherDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    class CityDetailViewHolder(private val viewBinding: ItemCityWeatherDetailBinding) :
        BaseViewHolder<WeatherData>(viewBinding.root) {

        override fun onBind(item: WeatherData) {
            super.onBind(item)
            with(viewBinding) {
                dateTextView.text = itemView.context.getString(
                    R.string.date,
                    DateTimeUtils.getFormattedDate(item.date)
                )
                dayTemperatureTextView.text = itemView.context.getString(
                    R.string.day_temperature,
                    BaseConverter.fromKelvinToCelsius(item.dayTemp)
                )
                nightTemperatureTextView.text = itemView.context.getString(
                    R.string.night_temperature,
                    BaseConverter.fromKelvinToCelsius(item.nightTemp)
                )
            }
        }
    }
}