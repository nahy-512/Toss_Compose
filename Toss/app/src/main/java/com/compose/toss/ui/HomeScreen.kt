package com.compose.toss.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R
import com.compose.toss.data.Assets
import com.compose.toss.data.assets

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp, vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TossHomeTopBar(modifier = Modifier)
            TossBankContainer(modifier = Modifier)
            AssetContainer(modifier = Modifier)
        }
    }
}

@Composable
private fun TossHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        TossLogo(
            modifier = Modifier
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_place),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .size(32.dp)
                    .padding(3.dp)
                    .offset(x = (-20).dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_alert),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .size(32.dp)
                    .padding(3.dp)
            )
        }
    }
}

@Composable
fun TossLogo(
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(50.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo_toss_symbol),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = stringResource(R.string.app_name),
            modifier = modifier
                .size(30.dp)
        )
        Image(
            painter = painterResource(R.drawable.logo_toss_text),
            contentDescription = stringResource(R.string.app_name),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            modifier = modifier
                .width(60.dp)
                .height(30.dp)
                .offset(4.dp)
        )
    }
}

@Composable
private fun TossBankContainer(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
            .offset(y = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(horizontal = 22.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "토스뱅크",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = modifier
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
}

@Composable
private fun AssetContainer(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
            .offset(y = 32.dp)
    ) {
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            for (asset in assets) {
                AssetItem(
                    asset = asset,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun AssetItem(
    asset: Assets,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            AssetsBankIcon(asset.bankType.logo, Modifier)
            AssetsInformation(asset.name, asset.sum)
            Spacer(Modifier.weight(1f))
            AssetsRemitButton(asset.canRemit)
        }
    }
}

@Composable
fun AssetsBankIcon(
    @DrawableRes bankIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop, // 이미지를 도형에 맞게 자름
        painter = painterResource(bankIcon),
        contentDescription = null
    )
}

@Composable
fun AssetsInformation(
    @StringRes assetsName: Int,
    sum: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .offset(x = dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(assetsName),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.width(dimensionResource(R.dimen.padding_small)))
        Text(
            text = stringResource(R.string.wons, "%,d".format(sum)),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AssetsRemitButton(
    canRemit: Boolean,
    modifier: Modifier = Modifier
) {
    if (canRemit) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.remit),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 14.dp)
            )
        }
    }
}