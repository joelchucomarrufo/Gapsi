package chuco.joel.gapsi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import chuco.joel.gapsi.view.feature.home.HomeScreen

@Composable
fun NavigationRoute(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = GapsiRoute.Home
    ) {

        composable<GapsiRoute.Home> {
            HomeScreen()
        }


    }

}