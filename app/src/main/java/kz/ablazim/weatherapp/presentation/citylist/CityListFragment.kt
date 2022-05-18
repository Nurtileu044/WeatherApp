package kz.ablazim.weatherapp.presentation.citylist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.databinding.FragmentCityListBinding
import kz.ablazim.weatherapp.extensions.observeNotNull
import kz.ablazim.weatherapp.extensions.replaceFragment
import kz.ablazim.weatherapp.presentation.addnewcity.NewCityDialog
import kz.ablazim.weatherapp.presentation.addnewcity.NewCityDialogCallback
import kz.ablazim.weatherapp.presentation.citydetail.CityDetailFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityListFragment : Fragment(R.layout.fragment_city_list), NewCityDialogCallback {

    private lateinit var binding: FragmentCityListBinding
    private val viewModel: CityListViewModel by viewModel()

    private val cityListAdapter: CityListAdapter by lazy {
        CityListAdapter(onItemClicked = { info -> viewModel.onItemClicked(info) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCityListBinding.bind(view)

        with(binding) {
            toolbar.setOnMenuItemClickListener { menuItem ->
                viewModel.onMenuItemClicked(menuItem)
                true
            }
            citiesRecyclerView.adapter = cityListAdapter
            citiesRecyclerView.itemAnimator = DefaultItemAnimator()

            viewModel.progressLoading.observeNotNull(viewLifecycleOwner) { isLoading ->
                progressStateView.isVisible = isLoading
            }

            viewModel.cityInfo.observeNotNull(viewLifecycleOwner) { cityInfoList ->
                cityListAdapter.setItems(cityInfoList)
            }

            viewModel.actions.observeNotNull(viewLifecycleOwner) { action ->
                when (action) {
                    is CityListAction.AddNewCity -> NewCityDialog.show(childFragmentManager)
                    is CityListAction.ShowCityDetailScreen -> replaceFragment(
                        CityDetailFragment.create(
                            latitude = action.cityWeatherInfo.latitude.toString(),
                            longitude = action.cityWeatherInfo.longitude.toString(),
                            cityName = action.cityWeatherInfo.cityName,
                            temp = action.cityWeatherInfo.temperature,
                            tempDescription = action.cityWeatherInfo.weatherDescp,
                            feelsLike = action.cityWeatherInfo.feelsLike,
                            maxTemp = action.cityWeatherInfo.maxTemp,
                            minTemp = action.cityWeatherInfo.minTemp,
                            windSpeed = action.cityWeatherInfo.windSpeed
                        )
                    )
                }
            }
        }
    }

    override fun onNewCityNameAdded(cityName: String) {
        viewModel.onNewCityNameAdded(cityName)
    }
}