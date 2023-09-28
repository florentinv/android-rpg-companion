package com.fvanaldewereld.rpgcompanion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fvanaldewereld.rpgcompanion.home.feature.ui.component.HomeScreen
import com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.component.BLOUPScreen
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
            SplashScreen {
                // Quand l'animation est finie on peut passer à la suite
                navHostController.popBackStack()
                navHostController.navigate(MainNavigationRoute.Home.route)
            }
        }

        composable(route = MainNavigationRoute.Home.route) {
            // Autant appeler directement la fonction composable, j'ai l'impression que passer par un intent faisait foirer le truc
            HomeScreen { /* Gérer le onclick par un callback vers Main ou par l'appel d'une nouvelle route */ }
        }
    }
}
