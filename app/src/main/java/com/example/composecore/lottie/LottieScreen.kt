package com.example.composecore.lottie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieScreen() {
    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.Asset("comp.json")
    )
    Column {
        Text(text = "hi")
        LottieAnimation(
            modifier = Modifier
                .width(180.dp)
                .height(242.dp),
            composition = lottieComposition,
        )
    }
    
}