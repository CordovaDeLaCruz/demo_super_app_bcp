package com.demo.feature.session.home.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.feature.session.home.presentation.components.UserItemCard
import com.demo.feature.session.home.presentation.model.UserModel
import com.demo.share.libs.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val userData = listOf(
        UserModel(
            id = 1,
            email = "",
            first_name = "Abrir aar con compose",
            last_name = "",
            avatar = "https://reqres.in/img/faces/1-image.jpg"
        ),
        UserModel(
            id = 2,
            email = "",
            first_name = "Abrir aar con viewbinding",
            last_name = "",
            avatar = "https://reqres.in/img/faces/2-image.jpg"
        ),
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
                        painter = painterResource(id = R.drawable.ic_logo),
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
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(items = userData) { user ->
                            UserItemCard(
                                user = user,
                                navigateToAar = {

                                }
                            )
                        }
                    }
                }
            }
        }
    )

}