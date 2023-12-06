package com.demo.features.security.login.presentation.loginvalidate

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object Login : LoginEvent()

    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : LoginEvent()
    object DismissDialog : LoginEvent()
    data class ChangeIsShowDialog(val value: Boolean) : LoginEvent()
}
