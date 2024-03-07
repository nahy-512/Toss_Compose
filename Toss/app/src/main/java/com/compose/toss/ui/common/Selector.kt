package com.compose.toss.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R

@Composable
fun SelectorContainer(titleList: List<Int>, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.padding_medium),
                )
        ) {
            titleList.forEachIndexed { index, titleResId ->
                SelectorText(titleResId)
                if (index < titleList.size - 1) {
                    SelectorSeparator(modifier)
                }
            }
        }
    }
}

@Composable
fun SelectorText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
fun SelectorSeparator(modifier: Modifier = Modifier) {
    // 세로 방향의 구분선
    Box(
        modifier
            .height(24.dp)
            .width(dimensionResource(R.dimen.divider_width))
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    )
}