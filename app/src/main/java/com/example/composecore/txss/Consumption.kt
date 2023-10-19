package com.example.composecore.txss

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.extensions.toMoney
import com.example.composecore.ui.theme.Blue100
import com.example.composecore.ui.theme.Gray100
import com.example.composecore.ui.theme.Gray200
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray500
import com.example.composecore.ui.theme.Green400
import com.example.composecore.ui.theme.Red200

fun LazyListScope.consumption() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Gray50)
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.round_arrow_left_24),
                contentDescription = "left",
                colorFilter = ColorFilter.tint(color = Gray200)
            )
            Text("10월", color = Color.White)
            Image(
                painter = painterResource(id = R.drawable.round_arrow_right_24),
                contentDescription = "right",
                colorFilter = ColorFilter.tint(color = Gray200)
            )
        }
    }
    item {
        AnimatedText()
    }
    item {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Gray500,
                        fontSize = 16.sp
                    )
                ) {
                    append("지난달 이맘때보다 ")
                }
                withStyle(
                    SpanStyle(
                        color = Red200,
                        fontSize = 16.sp
                    )
                ) {
                    append("9만 5,422원 ")
                }
                withStyle(
                    SpanStyle(
                        color = Gray500,
                        fontSize = 16.sp
                    )
                ) {
                    append("더 쓰고 있어요.")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Gray50)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )
    }
    item {
        Text(
            text = "모임카드",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Gray50)
                .padding(top = 25.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
        )
    }
    item {
        ConsumptionInfo(
            image = R.drawable.round_credit_card_24,
            imageTint = Green400,
            title = "희수님이 쓴 금액",
            money = "141,197원",
            isArrowVisible = true
        )
    }
    item {
        Text(
            text = "통장",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Gray50)
                .padding(top = 25.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
        )
    }
    item {
        ConsumptionInfo(
            image = R.drawable.round_favorite_24,
            imageTint = Red200,
            title = "통장에서 쓴 금액",
            money = "129,965원",
            isArrowVisible = false
        )
    }
    item {
        Box(
            modifier = Modifier
                .background(color = Gray50)
                .padding(top = 10.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .background(color = Gray100, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.round_how_to_vote_24),
                    contentDescription = "vote",
                    colorFilter = ColorFilter.tint(color = Blue100),
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "희수님의 의견을 듣고싶어요",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 14.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.round_keyboard_arrow_right_24),
                contentDescription = "more",
                colorFilter = ColorFilter.tint(Gray200),
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
    item {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray50)
                .padding(bottom = 200.dp)
        )
    }
}

@Composable
fun ConsumptionInfo(
    @DrawableRes image: Int,
    @ColorRes imageTint: Color,
    title: String,
    money: String,
    isArrowVisible: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "card",
                modifier = Modifier
                    .background(color = Color.White.copy(alpha = 0.2f), shape = CircleShape)
                    .padding(6.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = imageTint)
            )
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(text = title, color = Color.White)
                Text(text = money, color = Color.White)
            }
        }
        if (isArrowVisible) {
            Image(
                painter = painterResource(id = R.drawable.round_keyboard_arrow_right_24),
                contentDescription = "more",
                colorFilter = ColorFilter.tint(Gray200),
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

@Composable
fun AnimatedText() {
    var animatedValue by remember {
        mutableLongStateOf(0L)
    }
    LaunchedEffect(true) {
        val animationSpec = tween<Float>(
            durationMillis = 2000,
            easing = LinearEasing
        )
        animate(
            initialValue = 0f,
            targetValue = 271162f,
            animationSpec = animationSpec,
            block = { value, _ ->
                animatedValue = value.toLong()
            }
        )
    }

    Text(
        text = "총 ${animatedValue.toMoney()}원",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50)
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
    )
}