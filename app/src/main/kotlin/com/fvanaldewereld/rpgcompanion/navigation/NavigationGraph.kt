package com.fvanaldewereld.rpgcompanion.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fvanaldewereld.rpgcompanion.home.ui.components.HomeScreen
import com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.components.SplashScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.components.ScenarioDetailScreen
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.components.ScenarioListScreen

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationRoute.Splash.route,
    ) {
        composable(
            route = NavigationRoute.Splash.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition,
        ) {
            SplashScreen(
                onAnimationFinished = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Home.route)
                },
            )
        }
        composable(
            route = NavigationRoute.Home.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition,
        ) {
            HomeScreen(
                onGoToScenarioListButtonPressed = { navHostController.navigate(NavigationRoute.ScenarioList.route) },
            )
        }
        composable(
            route = NavigationRoute.ScenarioList.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition,
        ) {
            ScenarioListScreen(
                viewModel = viewModel(),
                onGoToScenarioDetailButtonPressed = { navHostController.navigate(NavigationRoute.ScenarioDetail.route) },
            ) {
                navHostController.popBackStack()
            }
        }
        composable(
            route = NavigationRoute.ScenarioDetail.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition,
        ) {
            ScenarioDetailScreen(
                viewModel = viewModel(),
            ) {
                navHostController.popBackStack()
            }
        }
    }
}

private val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(700),
    )
}

private val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = {
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(700),
    )
}

private val popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = {
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(700),
    )
}

private val popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = {
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(700),
    )
}
