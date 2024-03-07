package com.compose.toss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.compose.toss.ui.MainScreen
import com.compose.toss.ui.theme.TossTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossTheme {
                MainScreen()
            }
        }
    }
}