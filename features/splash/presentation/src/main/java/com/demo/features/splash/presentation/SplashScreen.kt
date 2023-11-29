package com.demo.features.splash.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SplashScreen(
    navController: NavController,
//    viewModel: SplashViewModel = hiltViewModel(),
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_logo),
//            contentDescription = stringResource(id = R.string.content_description_ic_logo),
//            contentScale = ContentScale.None
//        )
    }
}