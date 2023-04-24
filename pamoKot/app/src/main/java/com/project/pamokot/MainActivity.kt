package com.project.pamokot

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.project.pamokot.ui.theme.pages.Bmi
import com.project.pamokot.ui.theme.pages.Hb

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val showDialog = mutableStateOf(false)
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {

                Row() {
                    showBmi()
                }
                Row() {
                    showHb()
                }
                }

            }

        }
    }


@Composable
fun showBmi() {
    val showDialog = remember { mutableStateOf(false) }
    Button(onClick = { showDialog.value = true }) {
        Text("Bmi")
    }
    if (showDialog.value) {
        Bmi()
    }
}

@Composable
fun showHb() {
    val showDialog = remember { mutableStateOf(false) }
    Button(onClick = { showDialog.value = true }) {
        Text("HB")
    }
    if (showDialog.value) {
        Hb()
    }
}

