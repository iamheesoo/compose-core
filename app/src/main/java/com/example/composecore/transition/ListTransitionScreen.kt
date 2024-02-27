package com.example.composecore.transition

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composecore.composable.VerticalGrid
import com.example.composecore.dummy.imageList
import com.mxalbert.sharedelements.DelayExit
import com.mxalbert.sharedelements.FadeMode
import com.mxalbert.sharedelements.MaterialArcMotionFactory
import com.mxalbert.sharedelements.MaterialContainerTransformSpec
import com.mxalbert.sharedelements.ProgressThresholds
import com.mxalbert.sharedelements.SharedElementsRoot
import com.mxalbert.sharedelements.SharedElementsTransitionSpec
import com.mxalbert.sharedelements.SharedMaterialContainer


@Composable
fun ListTransitionScreen() {
    var isRow by remember {
        mutableStateOf(true)
    }
    SharedElementsRoot {
        Column {
            Button(onClick = { isRow = !isRow }) { Text(text = "button") }
            DelayExit(visible = isRow) {
                TwoRowAiSection()
            }
            DelayExit(visible = !isRow) {
                GridAiSection()
            }
        }
    }
}

@Composable
fun TwoRowAiSection() {
    val half = imageList.size / 2
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            LazyRow() {
                items(half) { index ->
                    SharedMaterialContainer(
                        key = ("image$index"),
                        screenKey = "from",
                        transitionSpec = MaterialFadeInTransitionSpec
                    ) {
                        DummyImage(
                            imageUrl = imageList[index],
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }
        item {
            LazyRow() {
                items(half) { index ->
                    SharedMaterialContainer(
                        key = "image${half + index}",
                        screenKey = "from",
                        transitionSpec = MaterialFadeInTransitionSpec
                    ) {
                        DummyImage(
                            imageUrl = imageList[half + index],
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GridAiSection() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(imageList) { index, url ->
            SharedMaterialContainer(
                key = "image$index",
                screenKey = "to",
                transitionSpec = MaterialFadeOutTransitionSpec
            ) {
                DummyImage(
                    imageUrl = url,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(CircleShape)
                )
            }
        }

    }
}

@Composable
fun DummyImage(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier,
        model = imageUrl,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

private const val TransitionDurationMillis = 1000

private val FadeOutTransitionSpec = MaterialContainerTransformSpec(
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.Out
)
private val CrossFadeTransitionSpec = SharedElementsTransitionSpec(
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.Cross,
    fadeProgressThresholds = ProgressThresholds(0.10f, 0.40f)
)
private val MaterialFadeInTransitionSpec = MaterialContainerTransformSpec(
    pathMotionFactory = MaterialArcMotionFactory,
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.In
)
private val MaterialFadeOutTransitionSpec = MaterialContainerTransformSpec(
    pathMotionFactory = MaterialArcMotionFactory,
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.Out
)