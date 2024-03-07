package com.compose.toss.ui

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Divider
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
import com.compose.toss.data.BankType
import com.compose.toss.data.assets
import java.time.LocalDate

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TossHomeTopBar(modifier = Modifier) // TODO: 탑바 상단 고정
            TossBankContainer(modifier = Modifier)
            Spacer(Modifier.height(dimensionResource(R.dimen.padding_default)))
            AssetContainer(modifier = Modifier)
            Spacer(Modifier.height(dimensionResource(R.dimen.padding_default)))
            CurrentMonthSpendContainer(modifier = Modifier)
            Spacer(Modifier.height(dimensionResource(R.dimen.padding_default)))
            SelectorContainer(modifier = Modifier)
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_bottom)))
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
            .padding(vertical = dimensionResource(R.dimen.padding_default))
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
            )
            Spacer(modifier.width(20.dp))
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
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.container_padding_horizontal),
                    vertical = dimensionResource(R.dimen.container_padding_vertical)
                )
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.toss_bank),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = modifier
                    .size(dimensionResource(R.dimen.arrow_image_size))
            )
        }
    }
}

@Composable
private fun DefaultContainerWithBottomText(
    content: @Composable (Modifier) -> Unit,
    @StringRes bottomText: Int,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = dimensionResource(R.dimen.container_padding_horizontal), vertical = dimensionResource(R.dimen.container_padding_vertical))
        ) {
            content(modifier)
            DefaultContainerBottom(bottomText, modifier)
        }
    }
}

@Composable
private fun AssetContainer(
    modifier: Modifier = Modifier
) {
    DefaultContainerWithBottomText(
        content = {
            for (asset in assets) {
                AssetItem(
                    asset = asset,
                    modifier = modifier
                )
                Spacer(modifier.height(dimensionResource(R.dimen.padding_medium)))
            }
        },
        bottomText = R.string.assets_view_more,
        modifier = modifier
    )
}

@Composable
private fun DefaultContainerBottom(@StringRes text: Int, modifier: Modifier = Modifier) {
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun CurrentMonthSpendContainer(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    ) {
        Box(modifier = modifier.padding(vertical = dimensionResource(R.dimen.container_padding_vertical), horizontal = dimensionResource(R.dimen.container_padding_horizontal))) {
            AssetItem(asset = Assets(BankType.Card, stringResource(R.string.month_spend, LocalDate.now().monthValue), 246708, true)) // 현재 달
        }
    }
}

@Composable
fun SelectorContainer(modifier: Modifier = Modifier) {
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
            SelectorText(R.string.selector_home_account)
            SelectorSeparator(modifier)
            SelectorText(R.string.selector_home_card)
            SelectorSeparator(modifier)
            SelectorText(R.string.selector_home_loan)
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
                .padding(dimensionResource(R.dimen.padding_mini))
        ) {
            if (asset.bankType == BankType.Card) {
                CardIcon(asset.bankType.logo, Modifier)
            } else {
                AssetsBankIcon(asset.bankType.logo, Modifier)
            }
            Spacer(modifier.width(dimensionResource(R.dimen.padding_medium)))
            AssetsInformation(asset.name, asset.sum)
            Spacer(modifier.weight(1f))
            if (asset.bankType == BankType.Card) {
                TextButton(stringResource(R.string.breakdown))
            } else {
                if (asset.showButton) {
                    TextButton(stringResource(R.string.remit))
                }
            }
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
fun CardIcon(
    @DrawableRes cardIcon: Int,
    modifier: Modifier = Modifier
) {
    // TODO: 카드 이미지 추가
    Image(
        modifier = modifier
            .width(24.dp)
            .height(36.dp)
            .size(50.dp),
        contentScale = ContentScale.Crop, // 이미지를 도형에 맞게 자름
        painter = painterResource(cardIcon),
        contentDescription = null
    )
}

@Composable
fun AssetsInformation(
    assetsName: String,
    sum: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = assetsName,
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
private fun TextButton(
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Card(
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
                .padding(vertical = dimensionResource(R.dimen.button_small_padding_vertical), horizontal = dimensionResource(R.dimen.button_small_padding_horizontal))
        )
    }
}