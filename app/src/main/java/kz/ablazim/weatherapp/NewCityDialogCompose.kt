package kz.ablazim.weatherapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun NewCity(value: String = "", addedCityName: (String) -> Unit, showDialog: (Boolean) -> Unit) {

    val textField = remember { mutableStateOf(value) }
    val textFieldError = remember { mutableStateOf("") }

    Dialog(onDismissRequest = { showDialog.invoke(false) }) {
        Surface(shape = RoundedCornerShape(6.dp), color = Color.White) {
            Box(contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = stringResource(id = R.string.add_new_city), style = TextStyle(fontSize = 24.sp))

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = textField.value,
                        onValueChange = { textField.value = it },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Gray.copy(alpha = 0.3f),
                            focusedIndicatorColor = MaterialTheme.colors.primary,
                            unfocusedIndicatorColor = Color.Gray
                        ),
                        placeholder = { Text(text = "Enter city name") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = { showDialog.invoke(false) }) {
                            Text("CANCEL", fontSize = 16.sp)
                        }
                        TextButton(onClick = {
                            if (textField.value.isEmpty()) {
                                textFieldError.value = "Field cannot be empty"
                                return@TextButton
                            }
                            addedCityName.invoke(textField.value)
                            showDialog.invoke(false)
                        }) {
                            Text("ADD", fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewNewCity() {
    NewCity(addedCityName = {

    }, showDialog = {

    })
}