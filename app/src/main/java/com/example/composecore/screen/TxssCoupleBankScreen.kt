package com.example.composecore.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.composecore.txss.HeartShape
import com.example.composecore.txss.TxssBottomBar
import com.example.composecore.txss.TxssTopBar
import com.example.composecore.txss.transactionHistory
import com.example.composecore.ui.theme.Gray200
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray50_70p
import com.example.composecore.ui.theme.Gray600
import com.example.composecore.ui.theme.Gray750
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun TxssCoupleBankScreen() {
    val pageList = listOf("거래내역", "소비")
    var tabIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TxssTopBar() },
        bottomBar = { TxssBottomBar() },
        containerColor = Gray200
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(HeartShape)
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
                                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
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
                0 -> transactionHistory()
                else -> item {
                    Text("text1")
                }
            }
        }
    }
}




