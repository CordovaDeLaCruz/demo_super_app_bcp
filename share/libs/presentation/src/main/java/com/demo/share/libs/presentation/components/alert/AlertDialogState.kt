package com.demo.share.libs.presentation.components.alert

data class AlertDialogState(
    val showDialog: Boolean = false,
    val state: String = AlertDialogViewState.Error.state,
    val code: String? = "",
    val title: String? = "",
    val text: String? = "",
    val textPrimary: String? = "",
    val textSecondary: String? = "",
)
