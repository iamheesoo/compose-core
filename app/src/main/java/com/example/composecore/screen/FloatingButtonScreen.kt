package com.example.composecore.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.composecore.R
import com.example.composecore.core.isStickyHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FloatingButtonScreen() {
    val list = List(1000) { "$it" }
    val listState = rememberLazyListState()
    val isButtonVisible = listState.isScrollInProgress.not()
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.gray_60)),
            state = listState
        ) {
            list.forEachIndexed { index, item ->
                if (index % 10 == 0) {
                    stickyHeader(key = "StickyHeader$index") {
                        StickyHeaderItem(text = item, listState = listState, itemKey = "StickyHeader$index")
                    }
                } else {
                    item {
                        ListItem(text = item)
                    }
                }
            }
        }
        AnimatedVisibility(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            visible = isButtonVisible,
            enter = slideIn(
                initialOffset = { IntOffset(0, it.height) },
                animationSpec = tween(200)
            ),
            exit = slideOut(
                targetOffset = { IntOffset(0, it.height) },
                animationSpec = tween(200)
            )
        ) {
            FloatingButton()
        }
    }
}

@Composable
fun ListItem(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = text
        )
        Divider(
            color = colorResource(id = R.color.gray_20),
            thickness = 1.dp
        )
    }
}

@Composable
fun StickyHeaderItem(listState: LazyListState, text: String, itemKey: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.gray_40))
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = text,
                color = colorResource(id = R.color.gray_100),
            )
        }
        if (isStickyHeader(listState = listState, itemKey = itemKey)) {
            Text(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.gray_60),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                    .align(Alignment.CenterEnd),
                text = "Focused",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.gray_90),

            )
        }
    }
}

@Composable
fun FloatingButton() {
    Row(
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(999.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.gray_20),
                shape = RoundedCornerShape(999.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(999.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "플로팅 버튼",
            fontWeight = FontWeight.Bold
        )
    }
}
