package com.demo.superappbcp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.demo.feature.session.home.presentation.homeGraph
import com.demo.features.security.login.presentation.loginGraph
import com.demo.share.libs.presentation.navigation.NavigationScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SecurityLoginNavScreen.route
    ){
        //splashGraph(navController)
        loginGraph(navController)
        homeGraph(navController)
    }
}