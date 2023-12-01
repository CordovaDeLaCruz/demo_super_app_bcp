package com.demo.features.security.login.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.demo.features.security.login.presentation.screen.LoginScreen
import com.demo.share.libs.presentation.navigation.NavigationScreen

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = com.demo.share.libs.constants.navigation.LoginNavScreen.SecurityLoginNavScreen.route,
        route = NavigationScreen.SecurityLoginNavScreen.route
    ) {

        composable(
            route = com.demo.share.libs.constants.navigation.LoginNavScreen.SecurityLoginNavScreen.route,
        ) {
            LoginScreen(navController)
        }
    }
}