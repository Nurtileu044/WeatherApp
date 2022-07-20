package kz.ablazim.weatherapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivityCompose : AppCompatActivity() {

    private val cityList: List<WeatherInfo> = listOf(
        WeatherInfo(cityName = "Almaty", weather = "Cloud", celcius = "18 C"),
        WeatherInfo(cityName = "Nur-Sultan", weather = "Rainy", celcius = "12 C"),
        WeatherInfo(cityName = "Moscow", weather = "Shiny", celcius = "21 C"),
        WeatherInfo(cityName = "Berlin", weather = "Cloud", celcius = "19 C"),
        WeatherInfo(cityName = "Tokyo", weather = "Rainy", celcius = "26 C"),
        WeatherInfo(cityName = "New York", weather = "Shiny", celcius = "25 C"),
        WeatherInfo(cityName = "Beijing", weather = "Foggy", celcius = "15 C"),
        WeatherInfo(cityName = "Malta", weather = "Rainy", celcius = "20 C")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication(cityList = cityList)
        }
    }

    @Composable
    fun MyApplication(cityList: List<WeatherInfo>) {
        Column(modifier = Modifier.fillMaxSize()) {
            cityList.forEach { weatherInfo ->
                Card(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min), elevation = 8.dp) {
                    Column {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                                .padding(start = 8.dp), text = weatherInfo.cityName, textAlign = TextAlign.Start
                        )

                        Text(modifier = Modifier.padding(start = 8.dp, bottom = 8.dp), text = weatherInfo.weather)
                    }

                    Box(contentAlignment = Alignment.CenterEnd) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            text = weatherInfo.celcius,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MyPreview() {
        MyApplication(cityList)
    }

    data class WeatherInfo(val cityName: String, val weather: String, val celcius: String)
}