package com.example.sermadcomposeapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.sermadcomposeapplication.ui.theme.SermadComposeApplicationTheme

class MainActivity : ComponentActivity() {

    private val TAG: String? = "MainActivity1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            SermadComposeApplicationTheme {
                ComponentA ()

            }
        }
    }

}

@Composable
private fun ComponentA() {
     val context = LocalContext.current
    Surface(color = Color.Yellow, modifier = Modifier
        .fillMaxSize()
        .clickable {
                 Intent (context, SecondActivity::class.java).also{
                     context.startActivity(it)
                 }
        }) {}
}
