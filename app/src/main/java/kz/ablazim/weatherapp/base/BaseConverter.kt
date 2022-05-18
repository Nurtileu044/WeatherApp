package kz.ablazim.weatherapp.base

private const val KELVIN_CONST = 275.15

object BaseConverter {
    fun fromKelvinToCelcius(kelvin: Double) = (kelvin - KELVIN_CONST).toInt().toString()
}