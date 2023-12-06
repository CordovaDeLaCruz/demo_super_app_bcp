package com.demo.features.security.login.presentation.loginvalidate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.demo.features.security.login.presentation.LoginApp
import com.demo.share.libs.constants.navigation.HomeNavScreen
import com.demo.share.libs.presentation.components.LoadingDialog
import com.demo.share.libs.presentation.components.alert.AlertDialog
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val loginApp: LoginApp = context.applicationContext as LoginApp

    val state = viewModel.state.value

    var username by remember { mutableStateOf(state.email) }
    var password by remember { mutableStateOf(state.password) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var showProgress by remember {
        mutableStateOf(false)
    }
    val alertDialogState = viewModel.alertDialog.value.copy()


    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is LoginViewModel.UiEvent.LoadingDialog -> {
                    showProgress = event.isShow
                }

                is LoginViewModel.UiEvent.SuccessLogin -> {
                    loginApp.setToken(event.token)
                    navController.navigate(HomeNavScreen.SessionHomeNavScreen.route)
                }

                is LoginViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        LoginEvent.ShowDialog(
                            code = event.code,
                            title = event.title,
                            message = event.text
                        )
                    )
                }
            }
        }
    }

    LoadingDialog(showDialog = showProgress)

    AlertDialog(
        state = alertDialogState.state,
        isShowDialog = alertDialogState.showDialog,
        title = alertDialogState.title,
        text = alertDialogState.text,
        textPrimary = alertDialogState.textPrimary,
        textSecondary = alertDialogState.textSecondary,
        buttonClose = false,
        onClickPrimary = {
            viewModel.onEvent(LoginEvent.ChangeIsShowDialog(false))
        },
        onClickClose = {
            viewModel.onEvent(LoginEvent.ChangeIsShowDialog(false))
        },
        onClickSecondary = {
            viewModel.onEvent(LoginEvent.ChangeIsShowDialog(false))
        }
    )
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.DarkGray
                ),
                title = {
                    Image(
                        painter = painterResource(id = com.demo.share.libs.presentation.R.drawable.ic_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp).fillMaxSize()
                ) {
                    OutlinedTextField(
                        value = username,
                        onValueChange = {
                            username = it
                            viewModel.onEvent(LoginEvent.EmailChanged(it))
                        },
                        label = { Text("Usuario") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            viewModel.onEvent(LoginEvent.PasswordChanged(it))
                        },
                        label = { Text("Contraseña") },
                        trailingIcon = {
                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                Icon(
                                    painter = if (isPasswordVisible) painterResource(id = com.demo.share.libs.presentation.R.drawable.ic_eyes_block) else
                                        painterResource(id = com.demo.share.libs.presentation.R.drawable.ic_eyes),
                                    contentDescription = null
                                )
                            }
                        },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            viewModel.onEvent(LoginEvent.Login)
                        }
                    )
                    {
                        Text("Ingresar")
                    }
                }
            }
        }
    )

}