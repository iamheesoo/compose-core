package com.example.composecore.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.composecore.R
import com.example.composecore.core.BetterBounceInterpolator
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScaffoldScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    BetterBounceInterpolator(1, 0.8).getInterpolation(it)
                }
            )
        )
    )


    /**
     * Collapsed가 되면 살짝 바운스하고 제자리
     */
    LaunchedEffect(true) {
        delay(1000)
        bottomSheetScaffoldState.bottomSheetState.expand()
    }


    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetBackgroundColor = colorResource(id = R.color.gray_100),
        sheetContent = {
            SheetContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(
                            topStart = if (bottomSheetScaffoldState.bottomSheetState.isExpanded) 0.dp else 30.dp,
                            topEnd = if (bottomSheetScaffoldState.bottomSheetState.isExpanded) 0.dp else 30.dp
                        ),
                        color = Color.White
                    )
            )
        },
        sheetPeekHeight = 100.dp,
        content = {
            MainContent(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.gray_100)),
            )
        }
    )
}

@Composable
fun SheetContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(20.dp)
    ) {
        List(1000) { it }.forEach {
            item {
                Text(text = it.toString())
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
    }
}
