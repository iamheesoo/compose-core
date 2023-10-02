package com.example.composecore.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.ui.theme.Gray100
import com.example.composecore.ui.theme.Gray200
import com.example.composecore.ui.theme.Gray300
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray50_30p
import com.example.composecore.ui.theme.Gray50_70p
import com.example.composecore.ui.theme.Gray600
import com.example.composecore.ui.theme.Gray700
import com.example.composecore.ui.theme.Gray750
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
@Preview
fun TxssCoupleBankScreen() {
    val pageList = listOf("거래내역", "소비")
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = Gray200
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = innerPadding
        ) {
            stickyHeader {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.CenterStart)
                    ) {
                        Text(
                            text = "커플통장 이름",
                            color = Gray400,
                            fontSize = 13.sp
                        )
                        Text(
                            text = "382,088원",
                            color = Gray750,
                            fontWeight = FontWeight.Bold,
                            fontSize = 27.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(50.dp)
                            .clip(HeartShape)
                    )
                }
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(HeartShape)
                )
            }
            item {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    modifier = Modifier.clip(
                        shape = RoundedCornerShape(
                            topStart = 20.dp, topEnd = 20.dp
                        )
                    ),
                    containerColor = Gray50_70p,
                    contentColor = Gray600,
                    indicator = { tabPositions ->

                    },
                ) {
                    pageList.forEachIndexed { index, page ->
                        Tab(
                            text = { Text(pageList[index]) },
                            selected = pagerState.currentPage == index,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterStart),
            tint = Color.White
        )
        Text(
            text = "관리",
            modifier = Modifier.align(Alignment.CenterEnd),
            color = Color.White
        )
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Gray100,
                contentColor = Gray400,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Black
            ),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(
                text = "꺼내기",
                fontWeight = FontWeight.W600
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Gray300,
                contentColor = Gray700,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Black
            ),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(
                text = "채우기",
                fontWeight = FontWeight.W600
            )
        }
    }
}

val HeartShape = GenericShape { size, _ ->
    val h = size.height
    val w = size.width
    lineTo(0.5f * w, 0.25f * h)
    cubicTo(
        0.5f * w,
        0.225f * h,
        0.458333333333333f * w,
        0.125f * h,
        0.291666666666667f * w,
        0.125f * h
    )
    cubicTo(
        0.0416666666666667f * w,
        0.125f * h,
        0.0416666666666667f * w,
        0.4f * h,
        0.0416666666666667f * w,
        0.4f * h
    )
    cubicTo(
        0.0416666666666667f * w,
        0.583333333333333f * h,
        0.208333333333333f * w,
        0.766666666666667f * h,
        0.5f * w,
        0.916666666666667f * h
    )
    cubicTo(
        0.791666666666667f * w,
        0.766666666666667f * h,
        0.958333333333333f * w,
        0.583333333333333f * h,
        0.958333333333333f * w,
        0.4f * h
    )
    cubicTo(
        0.958333333333333f * w,
        0.4f * h,
        0.958333333333333f * w,
        0.125f * h,
        0.708333333333333f * w,
        0.125f * h
    )
    cubicTo(0.583333333333333f * w, 0.125f * h, 0.5f * w, 0.225f * h, 0.5f * w, 0.25f * h)
    close()
}