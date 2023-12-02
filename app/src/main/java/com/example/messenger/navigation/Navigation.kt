package com.example.messenger.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.messenger.screens.ChatScreen
import com.example.messenger.screens.HomeScreen
import com.example.messenger.screens.SplashScreen

@Composable
fun NavigationController(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Splash.route) {

        composable(Screens.Splash.route) {

            SplashScreen(navController)

        }
        composable(Screens.Home.route) {

            HomeScreen(navController)

        }
        
        composable(Screens.Chats.route){
            
            ChatScreen(navController)
            
        }
    }

}