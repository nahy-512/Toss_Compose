package com.compose.toss.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.toss.BottomNavItem
import com.compose.toss.BottomNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        Box(Modifier.padding(it)){
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf<BottomNavItem>(
        BottomNavItem.Home,
        BottomNavItem.Benefit,
        BottomNavItem.Pay,
        BottomNavItem.Stock,
        BottomNavItem.Whole
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        screens.forEach { screens ->
            AddItem(item = screens, currentDestination = currentDestination, navController =navController )
        }
    }
}


@Composable
fun RowScope.AddItem(
    item: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = { Text(text = stringResource(item.title), fontSize = 10.sp) },
        icon = {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = item.route,
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == item.route
        } == true,
        selectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        unselectedContentColor = MaterialTheme.colorScheme.onSurface,
        onClick = {
            navController.navigate(item.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop =true
            }
        }
    )
}