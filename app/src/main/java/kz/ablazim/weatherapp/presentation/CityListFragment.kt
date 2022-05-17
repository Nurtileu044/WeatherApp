package kz.ablazim.weatherapp.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.databinding.FragmentCityListBinding
import kz.ablazim.weatherapp.extensions.observeNotNull
import kz.ablazim.weatherapp.presentation.addNewCity.NewCityDialog
import kz.ablazim.weatherapp.presentation.addNewCity.NewCityDialogCallback
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

            viewModel.progressLoading.observeNotNull(viewLifecycleOwner) { isLoading ->
                progressStateView.isVisible = isLoading
            }

            viewModel.cityInfo.observeNotNull(viewLifecycleOwner) { cityInfoList ->
                cityListAdapter.setItems(cityInfoList)
            }

            viewModel.actions.observeNotNull(viewLifecycleOwner) { action ->
                when (action) {
                    CityListAction.AddNewCity -> NewCityDialog.show(childFragmentManager)
                }
            }
        }
    }

    override fun onNewCityNameAdded(cityName: String) {
        viewModel.onNewCityNameAdded(cityName)
    }
}