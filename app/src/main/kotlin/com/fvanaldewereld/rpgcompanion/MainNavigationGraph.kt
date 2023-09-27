package com.fvanaldewereld.rpgcompanion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.component.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun MainNavigationGraph(
    navHostController: NavHostController,
    goToHomePage: () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = MainNavigationRoute.Splash.route,
    ) {
        composable(route = MainNavigationRoute.Splash.route) {
            LaunchedEffect(true) {
                delay(5000)
                navHostController.popBackStack()
                navHostController.navigate(MainNavigationRoute.Home.route)
            }
            SplashScreen()
        }

        composable(route = MainNavigationRoute.Home.route) {
            goToHomePage()
        }
    }
}
