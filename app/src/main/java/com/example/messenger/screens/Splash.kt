package com.example.messenger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.messenger.R
import com.example.messenger.module.IconComponentImageVector
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val animation by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 290.dp, bottom = 70.dp),
            horizontalArrangement = Arrangement.Center
        ) {


            IconButton(

                onClick = { navController.navigate("home") }) {

                IconComponentImageVector(icon = Icons.Default.PlayArrow, size = 30.dp)
            }

            Text(text = "Skip", modifier = Modifier.padding(top = 13.dp))

        }
        LottieAnimation(composition = animation)
        LaunchedEffect(key1 = true) {

            delay(10000L)
            navController.navigate("home")

        }

    }

}


@Preview
@Composable
private fun TestUI() {

    SplashScreen(navController = rememberNavController())

}
