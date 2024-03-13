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
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavItem.Benefit.route){
            BenefitScreen()
        }
        composable(route = BottomNavItem.Pay.route){
            PayScreen()
        }
        composable(route = BottomNavItem.Stock.route){
            StockScreen()
        }
        composable(route = BottomNavItem.Whole.route){
            WholeScreen()
        }
    }
}