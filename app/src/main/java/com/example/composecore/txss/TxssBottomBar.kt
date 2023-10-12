package com.example.composecore.txss

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composecore.ui.theme.Gray100
import com.example.composecore.ui.theme.Gray300
import com.example.composecore.ui.theme.Gray400
import com.example.composecore.ui.theme.Gray50
import com.example.composecore.ui.theme.Gray50_70p
import com.example.composecore.ui.theme.Gray700


@Composable
fun TxssBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50)
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