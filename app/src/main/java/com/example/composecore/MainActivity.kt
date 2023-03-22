package com.example.composecore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecore.screen.MainScreen
import com.example.composecore.screen.WebScreen
import com.example.composecore.ui.theme.ComposeCoreTheme
import com.example.composecore.ui.theme.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationList = Navigation.values()
        setContent {
            ComposeCoreTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Navigation.MAIN.name) {
                    navigationList.forEach { navigation ->
                        composable(navigation.name) {
                            when (navigation) {
                                Navigation.MAIN -> MainScreen(navController = navController)
                                Navigation.WEB -> WebScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
