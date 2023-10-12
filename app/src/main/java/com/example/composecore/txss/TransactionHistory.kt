package com.example.composecore.txss

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.dummy.MoneyData
import com.example.composecore.dummy.txssDummyList
import com.example.composecore.extensions.toDate
import com.example.composecore.extensions.toMoney
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray700

fun LazyListScope.transactionHistory() {
    item {
        Menu()
    }
    items(txssDummyList.size) { index ->
        TransactionItem(txssDummyList[index])
    }
}


@Composable
fun Menu() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "방금 전",
                color = Gray400,
                fontSize = 14.sp
            )
            Image(
                painter = painterResource(id = R.drawable.round_replay_24),
                contentDescription = "reset",
                colorFilter = ColorFilter.tint(color = Gray400),
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(18.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(
                    text = "전체",
                    color = Gray400,
                    fontSize = 14.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.round_keyboard_arrow_down_24),
                    contentDescription = "down",
                    colorFilter = ColorFilter.tint(color = Gray400)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.round_search_24),
                contentDescription = "search",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(color = Gray400),
            )
        }
    }
}


@Composable
fun TransactionItem(data: MoneyData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = data.image),
            contentDescription = "transaction image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = data.title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(text = data.time, color = Color.White, fontSize = 14.sp)
            }
            Column(
                modifier = Modifier.align(Alignment.CenterEnd),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = if (data.isDeposit) "${data.money.toMoney()}원" else "-${data.money.toMoney()}원",
                    color = Gray700,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "${data.restMoney.toMoney()}원", color = Gray700, fontSize = 14.sp)
            }
        }

    }
}