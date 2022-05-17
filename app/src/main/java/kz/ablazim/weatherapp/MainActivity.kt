package kz.ablazim.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.ablazim.weatherapp.databinding.ActivityMainBinding
import kz.ablazim.weatherapp.presentation.CityListFragment
import kz.ablazim.weatherapp.extensions.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(CityListFragment())
        }
    }
}