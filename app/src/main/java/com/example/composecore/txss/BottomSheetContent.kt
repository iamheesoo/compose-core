package com.example.composecore.txss

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.core.onClick
import com.example.composecore.ui.theme.Blue100
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray550
import com.example.composecore.ui.theme.Green400
import com.example.composecore.ui.theme.Red200

@Composable
fun BottomSheetContent(
    onGalleryClick: () -> Unit,
    onDefaultClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "귀엽고 사랑스러운\n우리 사진을 올려주세요",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp
        )
        BottomSheetRowContent(
            image = R.drawable.round_image_24,
            text = "내 사진첩에서 고르기",
            color = Green400,
            onClick = onGalleryClick
        )
        BottomSheetRowContent(
            image = R.drawable.round_favorite_24,
            text = "기본 이미지로 적용하기",
            color = Red200,
            onClick = onDefaultClick
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue100,
                contentColor = Gray400,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.Black
            ),
            shape = RoundedCornerShape(14.dp),
            onClick = {
                onCloseClick.invoke()
            }) {
            Text(
                text = "닫기",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }

}

@Composable
fun BottomSheetRowContent(
    @DrawableRes image: Int,
    @ColorRes color: Color,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .onClick { onClick.invoke() }
            .padding(vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "find gallery",
                colorFilter = ColorFilter.tint(color = color)
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = text,
                color = Gray550,
                fontSize = 18.sp
            )
        }
        Image(
            modifier = Modifier.align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.round_keyboard_arrow_right_24),
            contentDescription = "arrow right",
            colorFilter = ColorFilter.tint(color = Gray550)
        )
    }

}