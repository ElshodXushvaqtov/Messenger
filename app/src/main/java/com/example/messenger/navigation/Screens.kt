package com.example.messenger.navigation

sealed class Screens(var title: String, var route: String) {

    object Home : Screens("Home", "home")

    object Splash : Screens("Splash", "splash")

}
