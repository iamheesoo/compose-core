package com.example.composecore.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.composecore.composable.CustomSlider

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GradientSliderScreen() {
    var sliderValue by remember {
        mutableStateOf(0f..100f)
    }
    Box(
        contentAlignment = Alignment.Center
    ) {
        CustomSlider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
            },
            activeTrackColors = listOf(Color.Red, Color.Yellow, Color.Green)
        )
    }
}