package com.example.sermadcomposeapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sermadcomposeapplication.ui.theme.SermadComposeApplicationTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    private val TAG: String? = "MainActivity1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            SermadComposeApplicationTheme {
                ComponentA()

            }
        }
    }

}


class ColorViewModel : ViewModel() {

    var colorFlow = MutableStateFlow(Color.Blue)
    fun changeColor() {
        colorFlow.update { getRandomColor() }
    }

    private fun getRandomColor(): Color {
        val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)
        return colors.random()
    }

}

@Composable
private fun ComponentA(vm: ColorViewModel = viewModel()) {

    val flowColor by vm.colorFlow.collectAsState()

    Surface(color = flowColor, modifier = Modifier
        .fillMaxSize()
        .clickable {
            vm.changeColor()
        }) {}
}



