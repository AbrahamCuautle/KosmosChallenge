package com.example.kosmoschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kosmoschallenge.ui.screen.RickMortyScreen
import com.example.kosmoschallenge.ui.theme.KosmosChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KosmosChallengeTheme {
                RickMortyScreen()
            }
        }
    }
}
