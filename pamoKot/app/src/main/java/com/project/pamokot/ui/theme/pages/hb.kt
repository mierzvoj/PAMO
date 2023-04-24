package com.project.pamokot.ui.theme.pages

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.pamokot.R
import kotlin.text.Typography.times

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hb() {
    var heightInput: String by remember { mutableStateOf("") }
    var weightInput: String by remember { mutableStateOf("") }
    var ageInput: String by remember { mutableStateOf("") }
    var genderInput: String by remember { mutableStateOf("") }

    val height = heightInput.toIntOrNull() ?: 0
    val weight = weightInput.toIntOrNull() ?: 0
    val age = ageInput.toIntOrNull() ?: 0
    val gender = genderInput
    val hb: Double = if (gender == "m") {
        (66.47 +  13.7 * weight + 5.0 * height).minus(6.76 * age)

    } else {
        (655.1 + 9.567 * weight + 1.85 * height).minus(4.68 * age)
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    )
    {
        Text(
            text = stringResource(R.string.BH),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        TextField(
            value = heightInput,
            onValueChange = { heightInput = it },
            label = { Text(stringResource(R.string.heightIncm)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        TextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text(stringResource(R.string.age)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        TextField(
            value = weightInput,
            onValueChange = { weightInput = it },
            label = { Text(stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        TextField(
            value = genderInput,
            onValueChange = { genderInput = it },
            label = { Text(stringResource(R.string.gender)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(R.string.resultHb, String.format("%.2f", hb).replace(',','.')),
            modifier = Modifier
                .padding(20.dp),
            color = Color.Black
        )
    }
    Log.i("val", "$hb")
}

@Composable
@Preview
fun seeIt() {
    Hb()
}