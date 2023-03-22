package com.example.composecore.screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.TopAppBar
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composecore.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ColumnSampleScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                backIconClick = { navController.popBackStack() }
            )
        },
        content = { paddingValues ->
            SettingColumn()
        }
    )
}

@Preview
@Composable
fun TopBar(backIconClick: () -> Unit = {}) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.white),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .height(height = 56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon_back),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clickable {
                        backIconClick.invoke()
                    },
                contentScale = ContentScale.Inside
            )
            Text(
                text = "Column 예시",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SettingColumn() {
    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        SettingItemTitle(text = "Title 1")
        SettingItemValue(text = "아이템 1")
        SettingItemValue(text = "아이템 2")
        SettingItemValue(text = "아이템 3")
        SettingItemViewLine()

        SettingItemTitle(text = "Title 2")
        SettingItemValue(text = "아이템 1", isSwitchVisible = true)
        SettingItemValue(text = "아이템 2", isSwitchVisible = true)
        SettingItemViewLine()

        SettingItemTitle(text = "Title 3")
        SettingItemValue(text = "아이템 1", isKakaoIconVisible = true)
        SettingItemValue(text = "아이템 2")
        SettingItemViewLine()

        SettingItemTitle(text = "Title 4")
        SettingItemValue(text = "아이템 1")
        SettingItemValue(text = "아이템 2")
        SettingItemViewLine()

        SettingItemValue(text = "Title 5")

        SettingItemUnregister()
    }
}

@Composable
fun SettingItemTitle(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(colorResource(id = R.color.white)),
    ) {
        Text(
            text = text,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp)
                .align(Alignment.CenterStart),
            color = colorResource(id = R.color.black),
            fontSize = 12.sp
        )
        Divider(
            color = colorResource(id = R.color.gray_20),
            thickness = 2.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SettingItemValue(text: String, isSwitchVisible: Boolean = false, isKakaoIconVisible: Boolean = false) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(colorResource(id = R.color.white))
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterStart),
            fontSize = 10.sp
        )
        Divider(
            color = colorResource(id = R.color.gray_20),
            thickness = 2.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

        when {
            isSwitchVisible -> {
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(id = R.color.gray_100),
                        uncheckedThumbColor = colorResource(id = R.color.gray_20),
                        checkedTrackColor = colorResource(id = R.color.gray_90),
                        uncheckedTrackColor = colorResource(id = R.color.gray_80)
                    ),
//                    interactionSource = remember { DisabledInteractionSource() },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
            isKakaoIconVisible -> {
                Image(
                    painter = painterResource(id = R.drawable.ic_icon_talk),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.CenterEnd)
                )
            }
            else -> {}
        }
    }
}

@Composable
fun SettingItemViewLine() {
    Divider(
        color = Color(0xFFF5F5F5),
        thickness = 5.dp
    )
}

@Preview
@Composable
fun SettingItemUnregister() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(colorResource(id = R.color.g50))
            .padding(start = 18.dp)
    ) {
        Text(
            text = "탈퇴하기",
            fontSize = 10.sp,
            color = colorResource(id = R.color.steel),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterStart),
        )
    }

}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}