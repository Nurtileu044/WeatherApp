package kz.ablazim.weatherapp.presentation.addNewCity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import kz.ablazim.weatherapp.R
import kz.ablazim.weatherapp.databinding.DialogNewCityBinding
import org.koin.ext.getFullName

class NewCityDialog : AppCompatDialogFragment(R.layout.dialog_new_city) {
    companion object {
        fun show(manager: FragmentManager) =
            NewCityDialog().show(manager, NewCityDialog::class.getFullName())
    }

    private lateinit var binding: DialogNewCityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogNewCityBinding.bind(view)

        with(binding) {
            addButton.setOnClickListener {
                (parentFragment as? NewCityDialogCallback)?.onNewCityNameAdded(
                    cityNameTextInputEditText.text.toString().trim()
                )
                dismiss()
            }
            cancelButton.setOnClickListener { dismiss() }
        }
    }
}

interface NewCityDialogCallback {
    fun onNewCityNameAdded(cityName: String)
}