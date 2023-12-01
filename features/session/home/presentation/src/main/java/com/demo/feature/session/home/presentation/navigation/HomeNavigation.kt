package com.demo.feature.session.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.demo.feature.session.home.presentation.screen.HomeScreen
import com.demo.share.libs.presentation.navigation.NavigationScreen


fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(
        startDestination = com.demo.share.libs.constants.navigation.HomeNavScreen.SessionHomeNavScreen.route,
        route = NavigationScreen.SessionHomeNavScreen.route
    ) {

        composable(
            route = com.demo.share.libs.constants.navigation.HomeNavScreen.SessionHomeNavScreen.route,
        ) {
            HomeScreen(navController)
        }
    }
}