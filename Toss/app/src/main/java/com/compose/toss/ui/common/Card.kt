package com.compose.toss.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R

@Composable
fun DefaultCardBackground(
    content: @Composable (Modifier) -> Unit,
    modifier: Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        content(modifier)
    }
}

@Composable
fun ContainerWithBottomText(
    title: String?,
    content: @Composable (Modifier) -> Unit,
    @StringRes bottomText: Int,
    modifier: Modifier = Modifier
) {
    DefaultCardBackground(
        content = {
            Column(
                modifier = modifier
                    .padding(horizontal = dimensionResource(R.dimen.container_padding_horizontal), vertical = dimensionResource(
                        R.dimen.container_padding_vertical)
                    )
            ) {
                if (title != null) {
                    Text(
                        title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier.height(dimensionResource(R.dimen.padding_medium)))
                }
                content(modifier)
                ContainerBottomShowMore(bottomText, modifier)
            }
        },
        modifier = modifier
    )
}

@Composable
fun ContainerBottomShowMore(@StringRes text: Int, modifier: Modifier = Modifier) {
    Divider(
        color = MaterialTheme.colorScheme.secondaryContainer,
        thickness = dimensionResource(R.dimen.divider_width),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_small))
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(text),
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = modifier
                    .size(18.dp)
            )
        }
    }
}
