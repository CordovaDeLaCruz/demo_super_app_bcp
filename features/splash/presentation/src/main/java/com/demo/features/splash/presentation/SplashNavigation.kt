package com.demo.features.splash.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.demo.share.libs.presentation.navigation.NavigationScreen

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation(
        startDestination = com.demo.share.libs.constants.navigation.SplashNavScreen.InitNavScreen.route,
        route = NavigationScreen.SplashNavScreen.route
    ) {

        composable(
            route = com.demo.share.libs.constants.navigation.SplashNavScreen.InitNavScreen.route,
        ) {
            SplashScreen(navController)
        }
    }
}