package com.fvanaldewereld.rpgcompanion.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fvanaldewereld.rpgcompanion.home.ui.components.HomeScreen
import com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.components.SplashScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.components.ScenarioDetailScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.components.ScenarioListScreen

@Composable
internal fun RPGCompanionNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.Splash.route) {
        // This lambda navigates back in the navigation stack.
        val navigateBack: () -> Unit = { navController.navigateUp() }

        // This lambda navigates to a specified route.
        val navigateTo: (navRoute: NavigationRoute) -> Unit = { navRoute ->
            navController.navigate(navRoute.route)
        }

        // This lambda navigates to a route while popping all destinations up to a specified route
        val navigatePopAllTo: (navRoute: NavigationRoute, navRouteToPopUpTo: NavigationRoute) -> Unit = { navRoute, navRouteToPopUpTo ->
            navController.navigate(navRoute.route) {
                // Configure popping behavior
                popUpTo(navRouteToPopUpTo.route) { inclusive = true }
            }
        }

        animatedComposable(route = NavigationRoute.Splash.route) {
            SplashScreen {
                navigatePopAllTo(NavigationRoute.Home, NavigationRoute.Splash)
            }
        }

        animatedComposable(route = NavigationRoute.Home.route) {
            HomeScreen {
                navigateTo(NavigationRoute.ScenarioList)
            }
        }

        animatedComposable(route = NavigationRoute.ScenarioList.route) {
            ScenarioListScreen(
                viewModel = viewModel(),
                onGoToScenarioDetailButtonPressed = { navigateTo(NavigationRoute.ScenarioDetail) },
                onBackButtonPressed = navigateBack,
            )
        }

        animatedComposable(route = NavigationRoute.ScenarioDetail.route) {
            ScenarioDetailScreen(
                viewModel = viewModel(),
                onBackButtonPressed = navigateBack,
            )
        }
    }
}

