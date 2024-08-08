package com.example.sermadcomposeapplication

import androidx.compose.ui.graphics.Color
import org.junit.jupiter.api.Assertions.*

class MainActivityKtTest {

    @org.junit.jupiter.api.Test
    fun getRandomColor() {
        val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)
        val randomColor = getRandomColor()
        assertTrue(colors.contains<Any>(randomColor))
    }
}