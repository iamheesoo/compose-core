package com.example.composecore.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.core.onClick
import com.example.composecore.txss.HeartShape
import com.example.composecore.txss.TxssBottomBar
import com.example.composecore.txss.TxssTopBar
import com.example.composecore.txss.transactionHistory
import com.example.composecore.ui.theme.Gray200
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray600
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class
)
@Composable
@Preview
fun TxssCoupleBankScreen() {
    val pageList = listOf("거래내역", "소비")
    var tabIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val isBigHeartVisible by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }
    val bigHeartOffset by remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }
    val topBarHeartAlpha = if (isBigHeartVisible) {
        bigHeartOffset / 300f
    } else {
        1f
    }
    val haptic = LocalHapticFeedback.current
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false
        )
    )
    val isBottomSheetVisible = bottomSheetScaffoldState.bottomSheetState.isVisible

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContainerColor = Gray200,
        sheetContent = {
            Text("sheetContent")
        },
    ) {
        Scaffold(
            modifier = Modifier
                .onClick {
                    coroutineScope.launch {
                        if (isBottomSheetVisible) {
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.hide()
                            }
                        }
                    }
                },
            topBar = {
                TxssTopBar(
                    imageAlpha = topBarHeartAlpha
                )
            },
            bottomBar = { TxssBottomBar() },
            containerColor = Gray200
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                state = listState
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .clip(HeartShape)
                            .onClick {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                coroutineScope.launch {
                                    if (!isBottomSheetVisible) {
                                        bottomSheetScaffoldState.bottomSheetState.expand()
                                    }
                                }
                            }
                    )
                }
                stickyHeader {
                    TabRow(
                        selectedTabIndex = tabIndex,
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 20.dp, topEnd = 20.dp
                            )
                        ),
                        containerColor = Gray50,
                        contentColor = Gray600,
                        divider = {
                            Box(
                                modifier = Modifier
                                    .height(1.dp)
                                    .background(color = Color.Gray)
                            )
                        },
                        indicator = { tabPositions ->
                            Box(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[tabIndex])
                                    .height(2.dp)
                                    .padding(horizontal = 10.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            )
                        },
                    ) {
                        pageList.forEachIndexed { index, page ->
                            Tab(
                                text = { Text(pageList[index], fontSize = 16.sp) },
                                selected = tabIndex == index,
                                onClick = {
                                    coroutineScope.launch {
                                        tabIndex = index
                                    }
                                }
                            )
                        }
                    }
                }

                when (tabIndex) {
                    0 -> transactionHistory(
                        isBottomSheetVisible = isBottomSheetVisible
                    )

                    else -> item {
                        Text("text1")
                    }
                }
            }
        }
    }

}





