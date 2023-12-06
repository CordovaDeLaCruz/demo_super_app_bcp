package com.demo.features.security.login.presentation.loginvalidate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.usecase.LoginUseCase
import com.demo.share.libs.presentation.components.alert.AlertDialogState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel(){

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val _alertDialog = mutableStateOf(
        AlertDialogState(
            showDialog = false
        )
    )
    val alertDialog: State<AlertDialogState> = _alertDialog

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.ShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    code = event.code,
                    title = event.title,
                    showDialog = true,
                    text = event.message,
                    textPrimary = event.textPrimary,
                    textSecondary = event.textSecondary
                )
            }
            is LoginEvent.DismissDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = false
                )
            }

            is LoginEvent.ChangeIsShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = event.value,
                )

            }
            is LoginEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is LoginEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is LoginEvent.Login -> {
                viewModelScope.launch{
                    _eventFlow.emit(UiEvent.LoadingDialog(true))
                    val request = LoginRequestModel(
                        email =_state.value.email,
                        password = _state.value.password
                    )
                    loginUseCase.invoke(loginRequestModel = request).onSuccess {
                        _eventFlow.emit(UiEvent.SuccessLogin(it.token))
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                        _state.value = _state.value.copy(email = "", password = "")
                    }.onFailure {
                        _eventFlow.emit(
                            UiEvent.ShowError(
                                code = "code",
                                title = "¡Error!",
                                text = "Algo salió mal, no podemos conectarnos",
                                textPrimary = "",
                                textSecondary = ""
                            )
                        )
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class LoadingDialog(val isShow: Boolean) : UiEvent()
        data class SuccessLogin(val token: String?) : UiEvent()

        data class ShowError(
            var code: String,
            var title: String,
            var text: String,
            var textPrimary: String?,
            var textSecondary: String?,
        ) : UiEvent()
    }
}