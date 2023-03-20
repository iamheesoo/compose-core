package com.example.composecore.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composecore.ui.theme.Navigation
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composecore.R

@Composable
fun MainScreen(navController: NavController) {
    val list = Navigation.values()

    LazyColumn() {
        items(items = list) {
            MainItem(title = it.name, onClick = { navController.navigate(it.name)})
        }
    }
}


@Composable
fun MainItem(title: String, onClick: (() -> Unit)) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(10.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable {
                    onClick.invoke()
                },
        )

        Divider(
            color = colorResource(id = R.color.gray_solitude),
            thickness = 2.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

