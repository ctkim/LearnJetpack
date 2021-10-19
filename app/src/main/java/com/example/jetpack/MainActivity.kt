package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Xtine's Jetpack App!")
        }
    }

    @Composable
    fun MessageCard(name: String) {
        Text("Hey there, $name!")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard("Player One")
    }
}