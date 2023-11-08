package com.example.composecore.flowrow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecore.core.CustomFlowRow

@Composable
fun FlowRowScreen() {
    Column {
        Text("flow row with max line 2")
        CustomFlowRow(spacing = 4.dp, maxLines = 2) {
            repeat(100) {
                Tag(it.toString())
            }
        }
    }
}

@Composable
fun Tag(tagText: String) {
    Text(
        text = tagText,
        fontWeight = FontWeight.Bold,
        fontSize = 8.sp,
        color = Color.Black,
        modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
}