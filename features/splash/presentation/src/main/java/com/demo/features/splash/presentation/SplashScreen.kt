package com.demo.features.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.share.libs.constants.navigation.LoginNavScreen
import com.demo.share.libs.presentation.navigation.NavigationScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
//    viewModel: SplashViewModel = hiltViewModel(),
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = com.demo.share.libs.presentation.R.drawable.ic_logo),
            contentDescription = stringResource(id = com.demo.share.libs.presentation.R.string.content_description_ic_logo),
            contentScale = ContentScale.None
        )
        LaunchedEffect(true) {
            delay(3000)
            navController.navigate(LoginNavScreen.SecurityLoginNavScreen.route){
                popUpTo(NavigationScreen.SplashNavScreen.route)
            }
        }
    }
}