package com.compose.toss

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.toss.ui.BenefitScreen
import com.compose.toss.ui.HomeScreen
import com.compose.toss.ui.PayScreen
import com.compose.toss.ui.StockScreen
import com.compose.toss.ui.WholeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Benefit.route){
            BenefitScreen()
        }
        composable(route = BottomBarScreen.Pay.route){
            PayScreen()
        }
        composable(route = BottomBarScreen.Stock.route){
            StockScreen()
        }
        composable(route = BottomBarScreen.Whole.route){
            WholeScreen()
        }
    }
}