package com.demo.share.libs.constants.navigation

sealed class HomeNavScreen(val route: String) {

    object SessionHomeNavScreen : HomeNavScreen("session_home_screen")

    fun witArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}