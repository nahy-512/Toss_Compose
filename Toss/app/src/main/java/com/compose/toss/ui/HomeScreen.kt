package com.compose.toss.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inverseOnSurface)
            .padding(horizontal = 22.dp, vertical = 10.dp)) {
            item {
                TossHomeTopBar(modifier = Modifier.fillMaxSize())
                Text(text = "Home Screen", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Composable
private fun TossHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        TossLogo(
            modifier = Modifier
        )
        Row {
            Image(
                painter = painterResource(R.drawable.ic_place),
                contentDescription = "",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .size(24.dp)
                    .offset(x = (-20).dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_alert),
                contentDescription = "",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun TossLogo(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.logo_toss_symbol),
            contentDescription = stringResource(R.string.app_name),
            modifier = modifier
                .size(30.dp)
        )
        Image(
            painter = painterResource(R.drawable.logo_toss_text),
            contentDescription = stringResource(R.string.app_name),
            modifier = modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .width(60.dp)
                .height(30.dp)
                .offset(4.dp)
        )
    }
}