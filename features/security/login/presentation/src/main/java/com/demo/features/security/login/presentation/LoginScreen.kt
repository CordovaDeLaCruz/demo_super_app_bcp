package com.demo.features.security.login.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.demo.share.libs.constants.navigation.HomeNavScreen

@Composable
fun LoginScreen(
    navController: NavController,
//    viewModel: SplashViewModel = hiltViewModel(),
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                navController.navigate(HomeNavScreen.SessionHomeNavScreen.route)
            }) {
            Text("go to home")
        }
    }

}