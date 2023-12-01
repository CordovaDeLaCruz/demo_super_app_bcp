package com.demo.share.libs.presentation.components.alert

sealed class AlertDialogViewState(var state: String) {
    object Confirm : AlertDialogViewState("Confirm")
    object Error : AlertDialogViewState("Error")
    object Info : AlertDialogViewState("Info")

}