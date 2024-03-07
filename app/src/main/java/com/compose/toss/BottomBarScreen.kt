package com.compose.toss

import androidx.compose.ui.graphics.vector.ImageVector
import com.compose.toss.ui.NavIconPack
import com.compose.toss.ui.naviconpack.Benefit
import com.compose.toss.ui.naviconpack.Home
import com.compose.toss.ui.naviconpack.Pay
import com.compose.toss.ui.naviconpack.Stock
import com.compose.toss.ui.naviconpack.Whole

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "홈",
        icon = NavIconPack.Home
    )
    object Benefit: BottomBarScreen(
        route = "benefit",
        title = "혜택",
        icon = NavIconPack.Benefit
    )
    object Pay: BottomBarScreen(
        route = "pay",
        title = "토스페이",
        icon = NavIconPack.Pay
    )
    object Stock: BottomBarScreen(
        route = "stock",
        title = "주식",
        icon = NavIconPack.Stock
    )
    object Whole: BottomBarScreen(
        route = "whole",
        title = "전체",
        icon = NavIconPack.Whole
    )
}