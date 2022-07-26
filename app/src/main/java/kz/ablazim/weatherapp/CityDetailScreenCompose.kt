package kz.ablazim.weatherapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val sampleList = listOf("Time: 10:41", "Time: 10:42", "Time: 10:43", "Time: 10:44", "Time: 10:45", "Time: 10:46")

@Composable
fun CityDetail() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(stringResource(id = R.string.cityName)) }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.ic_back), "")
            }
        })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text("28 C", fontSize = 50.sp)

            Spacer(modifier = Modifier.height(20.dp))

            Text("Clear", fontSize = 24.sp, color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.height(10.dp))

            Text("Feels like: 27 C", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Max Temperature: 28 C", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Min Temperature: 28 C", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Wind Speed: 2.0 m/s", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(18.dp))

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(items = sampleList, itemContent = { WeatherItem(text = it) })
            }
        }
    }
}

@Composable
fun WeatherItem(text: String) {
    Column(modifier = Modifier.width(IntrinsicSize.Max)) {
        Divider(
            color = Color.Black, modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
        ) {
            Column {
                Text(text = text, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = text, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = text, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
                    .width(2.dp)
            )
        }
        Divider(
            color = Color.Black, modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CityDetailPreview() {
    CityDetail()
}