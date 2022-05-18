package kz.ablazim.weatherapp.presentation.citylist

import android.view.LayoutInflater
import android.view.ViewGroup
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.base.BaseAdapter
import kz.ablazim.weatherapp.base.BaseViewHolder
import kz.ablazim.weatherapp.base.model.CityWeatherInfo
import kz.ablazim.weatherapp.databinding.ItemCityBinding

class CityListAdapter(private val onItemClicked: (info: CityWeatherInfo) -> Unit) :
    BaseAdapter<CityWeatherInfo>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CityWeatherInfo> = CityItemViewHolder(
        ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClicked
    )

    private class CityItemViewHolder(
        private val viewBinding: ItemCityBinding,
        onItemClicked: (info: CityWeatherInfo) -> Unit
    ) : BaseViewHolder<CityWeatherInfo>(viewBinding.root, onItemClicked) {

        override fun onBind(item: CityWeatherInfo) {
            super.onBind(item)
            with(viewBinding) {
                cityNameTextView.text = item.cityName
                weatherTextView.text = item.weatherDescp
                temperatureTextView.text =
                    itemView.context.getString(R.string.temperature_C, item.temperature)
            }
        }
    }
}