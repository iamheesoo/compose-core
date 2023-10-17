package com.example.composecore.txss

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.R
import com.example.composecore.ui.theme.Gray200
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray750


@Composable
fun TxssTopBar(imageAlpha: Float) {
    Column(
        modifier = Modifier
            .background(color = Gray200)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
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
                    .alpha(imageAlpha)
            )
        }
    }

}