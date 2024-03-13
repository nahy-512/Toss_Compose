package com.compose.toss.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R
import com.compose.toss.ui.theme.Shapes

@Composable
fun TextButton(
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = Shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier
    ) {
        Text(
            text = buttonText,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.button_small_padding_vertical), horizontal = dimensionResource(
                    R.dimen.button_small_padding_horizontal)
                )
        )
    }
}

@Composable
fun IconAndTextButton(
    icon: ImageVector,
    @StringRes buttonText: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = Shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                imageVector = icon,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onTertiaryContainer),
                modifier = Modifier.size(24.dp).weight(1f)
            )
            Text(
                text = stringResource(buttonText),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ArrowButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.ic_arrow_right),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
        modifier = modifier
            .size(dimensionResource(R.dimen.arrow_image_size))
    )
}