package com.compose.toss.ui

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.toss.R
import com.compose.toss.data.Assets
import com.compose.toss.data.BankType
import com.compose.toss.data.Recommend
import com.compose.toss.data.assets
import com.compose.toss.data.recommends
import com.compose.toss.ui.common.ArrowButton
import com.compose.toss.ui.common.DefaultCardBackground
import com.compose.toss.ui.common.ContainerWithBottomText
import com.compose.toss.ui.common.IconAndTextButton
import com.compose.toss.ui.common.SelectorContainer
import com.compose.toss.ui.common.TextButton
import java.time.LocalDate

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TossHomeTopBar()
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium),
                    top = contentPadding.calculateTopPadding()
                )
        ) {
            Spacer(modifier = Modifier.height(contentPadding.calculateTopPadding())) // Spacer with topBar height
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_default)),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TossBankContainer()
                AssetContainer()
                CurrentMonthSpendContainer()
                SelectorContainer(listOf(R.string.selector_home_account, R.string.selector_home_card, R.string.selector_home_loan))
                RecommendContainer(modifier = Modifier)
                Spacer(Modifier.height(dimensionResource(R.dimen.padding_mini)))
                ButtonLayer()
                PersonalInformationText(modifier = Modifier)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_bottom)))
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
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background) // TODO: 투명하다가 스크롤하면 흰색으로 변경시키기
            .padding(
                vertical = dimensionResource(R.dimen.padding_default),
                horizontal = dimensionResource(R.dimen.padding_medium)
            )
    ) {
        TossLogo()
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
    DefaultCardBackground(
        content = {
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
                ArrowButton()
            }
        },
        modifier = modifier
    )
}

@Composable
private fun AssetContainer(
    modifier: Modifier = Modifier
) {
    ContainerWithBottomText(
        title = null,
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
private fun RecommendContainer(modifier: Modifier) {
    ContainerWithBottomText(
        title = stringResource(R.string.recommend_title, "김나현"),
        content = {
            for (recommend in recommends) {
                RecommendItem(
                    item = recommend,
                    modifier = modifier
                )
                Spacer(modifier.height(dimensionResource(R.dimen.padding_medium)))
            }
        },
        bottomText = R.string.recommend_view_more,
        modifier = modifier
    )
}

@Composable
private fun ButtonLayer(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        IconAndTextButton(Icons.Filled.Settings, R.string.screen_setting, Modifier.weight(1f)) //modifier.fillMaxWidth(0.5f)
        IconAndTextButton(Icons.Filled.Add, R.string.add_asset, Modifier.weight(1f)) //modifier.fillMaxWidth().weight(1f)
    }
}

@Composable
private fun PersonalInformationText(modifier: Modifier) {
    Text(
        text = stringResource(R.string.personal_information),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
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
                CardIcon(asset.bankType.logo)
            } else {
                AssetsBankIcon(asset.bankType.logo)
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
fun RecommendItem(
    item: Recommend,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_mini))
        ) {
            Image(
                imageVector = item.icon,
                contentDescription = null,
                colorFilter = ColorFilter.tint(item.iconColor),
            )
            Spacer(modifier.width(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = item.content,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier.weight(1f))
            ArrowButton()
        }
    }
}

