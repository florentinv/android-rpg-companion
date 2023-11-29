package com.fvanaldewereld.rpgcompanion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fvanaldewereld.rpgcompanion.home.ui.components.HomeScreen
import com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.components.SplashScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.ScenarioDetailViewModel
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.components.ScenarioDetailScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.ScenarioListViewModel
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.components.ScenarioListScreen
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun RPGCompanionNavigation() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavigationRoute.Splash.route) {
        // This lambda navigates back in the navigation stack.
        val navigateBack: () -> Unit = { navHostController.navigateUp() }

        // This lambda navigates to a specified route.
        val navigateTo: (navRoute: NavigationRoute) -> Unit = { navRoute ->
            navHostController.navigate(navRoute.route)
        }

        // This lambda navigates to a specified route.
        val navigateToString: (navRoute: String) -> Unit = { navRoute ->
            navHostController.navigate(navRoute)
        }

        // This lambda navigates to a route while popping all destinations up to a specified route
        val navigatePopAllTo: (navRoute: NavigationRoute, navRouteToPopUpTo: NavigationRoute) -> Unit = { navRoute, navRouteToPopUpTo ->
            navHostController.navigate(navRoute.route) {
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
            val viewModel: ScenarioListViewModel = koinViewModel()
            ScenarioListScreen(
                viewModel = viewModel,
                onBackButtonPressed = navigateBack,
                onItemPressed = { scenarioId -> navigateToString(NavigationRoute.ScenarioDetail.createRoute(scenarioId = scenarioId)) },
            )
        }

        composable(
            route = NavigationRoute.ScenarioDetail.route,
        ) {
            val viewModel: ScenarioDetailViewModel = koinViewModel()
            ScenarioDetailScreen(
                viewModel = viewModel,
                onBackButtonPressed = navigateBack,
            )
        }
    }
}

