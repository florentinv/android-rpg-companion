package com.fvanaldewereld.rpgcompanion.navigation

sealed class NavigationRoute(val route: String) {
    object Splash : NavigationRoute("splash_screen")
    object Home : NavigationRoute("home_screen")
    object ScenarioList : NavigationRoute("scenario_list_screen")
    object ScenarioDetail : NavigationRoute("scenario_detail_screen")
}