package com.fvanaldewereld.rpgcompanion

sealed class MainNavigationRoute(val route: String) {
    object Splash : MainNavigationRoute("splash_screen")
    object Home : MainNavigationRoute("home_screen")
}