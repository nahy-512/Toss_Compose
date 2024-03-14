package com.compose.toss

sealed class BottomNavItem(
    val route: String,
    val title: Int,
    val icon: Int
){
    data object Home: BottomNavItem(
        route = "home",
        title = R.string.tab_home,
        icon = R.drawable.ic_home
    )
    data object Benefit: BottomNavItem(
        route = "benefit",
        title = R.string.tab_benefit,
        icon = R.drawable.ic_benefit
    )
    data object Pay: BottomNavItem(
        route = "pay",
        title = R.string.tab_pay,
        icon = R.drawable.ic_pay
    )
    data object Stock: BottomNavItem(
        route = "stock",
        title = R.string.tab_stock,
        icon = R.drawable.ic_stock
    )
    data object Whole: BottomNavItem(
        route = "whole",
        title = R.string.tab_whole,
        icon = R.drawable.ic_whole
    )
}