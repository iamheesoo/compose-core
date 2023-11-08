package com.example.composecore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecore.flowrow.FlowRowScreen
import com.example.composecore.screen.BottomSheetScaffoldScreen
import com.example.composecore.screen.ColumnSampleScreen
import com.example.composecore.screen.FloatingButtonScreen
import com.example.composecore.screen.GradientSliderScreen
import com.example.composecore.screen.MainScreen
import com.example.composecore.screen.HorizontalTabScreen
import com.example.composecore.screen.TxssCoupleBankScreen
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
                                Navigation.COLUMN_SAMPLE -> ColumnSampleScreen(navController = navController)
                                Navigation.FLOATING_BUTTON -> FloatingButtonScreen()
                                Navigation.HORIZONTAL_TAB -> HorizontalTabScreen()
                                Navigation.BOTTOM_SHEET_SCAFFOLD -> BottomSheetScaffoldScreen()
                                Navigation.GRADIENT_SLIDER -> GradientSliderScreen()
                                Navigation.TXSS_COUPLE_BANK -> TxssCoupleBankScreen()
                                Navigation.FLOW_ROW_MAX_LINE -> FlowRowScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
