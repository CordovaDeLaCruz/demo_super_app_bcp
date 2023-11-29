package com.demo.share.libs.presentation.navigation

sealed class NavigationScreen(val route: String) {

    object SplashNavScreen : NavigationScreen("splash")
    object SecurityLoginNavScreen : NavigationScreen("security_login")
    object SessionHomeNavScreen : NavigationScreen("session_home")
}