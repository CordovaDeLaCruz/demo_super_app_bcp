package com.demo.share.libs.constants.navigation


sealed class LoginNavScreen(val route: String) {

    object SecurityLoginNavScreen : LoginNavScreen("security_login_screen")

    fun witArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}